package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.dao.PassagemDao;
import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.dao.VooDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.CompanhiaAerea;
import br.com.negocio.entidade.Passagem;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.entidade.Voo;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.Status;
import br.com.negocio.excecoes.DaoAeroportoException;
import br.com.negocio.excecoes.DaoPassagemException;
import br.com.persistencia.conexao.Conexao;

public class PassagemDaoDerby implements PassagemDao {

	private CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
	private UsuarioDao usuarioDao = new UsuarioDaoDerby();

	@Override
	public void inserir(Passagem passagem) {
		String sql = "INSERT INTO PASSAGEM(CODIGOUSUARIO, COMPANHIA, NOMEPASSAGEIRO, STATUS, LIBERARCHECKIN, DATAHORA, ASSENTO, DOCUMENTO, LOCALIZADOR, VALOR) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {

			CompanhiaAerea companhiaAerea = companhiaAereaDao.buscarPorCodigo("ACME");
			Usuario usuario = usuarioDao.buscarPorCodigo(passagem.getUsuario().getCodigo());

			try (PreparedStatement statement = conexao.prepareStatement(sql)) {
				statement.setString(1, usuario.getCodigo());
				statement.setString(2, companhiaAerea.getCodigo());
				statement.setString(3, passagem.getNome());
				statement.setString(4, passagem.getStatus().toString());
				statement.setInt(5, passagem.getCheckin());
				statement.setTimestamp(6, passagem.getDataHora());
				statement.setInt(7, passagem.getNumeroAssento());
				statement.setString(8, passagem.getDocumento().toString());
				statement.setInt(9, passagem.getLocalizador());
				statement.setDouble(10, passagem.getValor());
				resultado = statement.executeUpdate();
			}
		} catch (DaoAeroportoException e) {
			new DaoPassagemException("ERRO: falha ao tentar inserir Passagem", e);
		} catch (Exception e) {
			new DaoPassagemException("ERRO: falha ao tentar inserir Passagem", e);
		}
		if (resultado == 0) {
			new DaoPassagemException("ERRO: falha passagem não inserida");
		}

	}

	@Override
	public Passagem buscarPeloCodigoDoUsuario(String codigo) {
		return null;
	}

	@Override
	public List<Passagem> buscarTodos() {
		String sqlPASSAGEM = "SELECT * FROM PASSAGEM";
		String sqlPASSAGEMVOO = "SELECT * FROM PASSAGEMVOO WHERE CODIGOPASSAGEM = ?";

		List<Passagem> passagens = new ArrayList<>();
        List<Voo> voos;
        VooDao vooDao = new VooDaoDerby();
        
        try (Connection conexao = Conexao.getConexao()) {
            try (Statement comandoPassagem = conexao.createStatement()) {
                try (ResultSet resultadoPassagem = comandoPassagem.executeQuery(sqlPASSAGEM)) {

                	while (resultadoPassagem.next()) {

                		try (PreparedStatement comandoPASSAGEMVOO = conexao.prepareStatement(sqlPASSAGEMVOO)) {
                        	comandoPASSAGEMVOO.setInt(1, resultadoPassagem.getInt("CODIGO"));
                            
                            try (ResultSet resultadoPASSAGEMVOO = comandoPASSAGEMVOO.executeQuery()) {
                            	voos = new ArrayList<>();
                                while (resultadoPASSAGEMVOO.next()) {
                                    int codAutor = resultadoPASSAGEMVOO.getInt("CODIGOVOO");
                                    voos.add(vooDao.buscarPorCodigo(codAutor));
                                }
                            }
                        }
                        Passagem passagem = new Passagem(
                        		usuarioDao.buscarPorCodigo(resultadoPassagem.getString("CODIGOUSUARIO")), 
                        		companhiaAereaDao.buscarPorCodigo(resultadoPassagem.getString("COMPANHIA")), 
                        		resultadoPassagem.getString("NOMEPASSAGEIRO"), 
                        		Status.valueOf(resultadoPassagem.getString("STATUS")), 
                        		resultadoPassagem.getInt("CHECKIN"), 
                        		resultadoPassagem.getTimestamp("DATAHORA"), 
                        		resultadoPassagem.getInt("ASSENTO"), 
                        		Documento.valueOf(resultadoPassagem.getString("DOCUMENTO")), 
                        		resultadoPassagem.getInt("LOCALIZADOR"), 
                        		resultadoPassagem.getDouble("VALOR"), 
                        		voos
                        );
                        for (int i = 1; i < voos.size(); i++) {
                        	passagem.addVoo(voos.get(i));
                        }
                        passagens.add(passagem);
                    }
                    return passagens;
                }
            }
        } catch (DaoAeroportoException e) {
			new DaoPassagemException("ERRO: falha ao tentar buscar Passagem", e);
		} catch (Exception e) {
			new DaoPassagemException("ERRO: falha ao tentar buscar Passagem", e);
		}
		return passagens;
	}
	
	public static void main(String[] args) {
		Usuario usuario = new Usuario("1", "emanoel", "12345");
		CompanhiaAerea companhiaAerea = new CompanhiaAerea("1", "A");
		Aeroporto a = new Aeroporto("1", "etste", "", "");
		Voo voo = new Voo("1", companhiaAerea, a, a, "", 0, "", 0, new Timestamp(System.currentTimeMillis()));
		List<Voo> lista = new ArrayList<>();
		lista.add(voo);
		
		Passagem passagem = new Passagem(usuario, companhiaAerea, "", Status.PENDENTE, 0, new Timestamp(System.currentTimeMillis()), 0, Documento.CPF, 0, 100, lista);
		PassagemDaoDerby daoDerby = new PassagemDaoDerby();
		daoDerby.inserir(passagem);
		
		List<Passagem> l= daoDerby.buscarTodos();
		for (Passagem passagem2 : l) {
			System.out.println(passagem2.getNome());
		}
		
		System.out.println("nada encontrado!");
	}
	
}
