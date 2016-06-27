package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.CompanhiaAerea;
import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.dao.VooDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Voo;
import br.com.negocio.excecoes.DaoVooException;
import br.com.persistencia.conexao.Conexao;

public class VooDaoDerby implements VooDao {

	private AeroportoDao aeroportoDao = new AeroportoDaoDerby();

	@Override
	public void inserir(Voo voo) throws DaoVooException {
		String sql = "INSERT INTO VOO(CODIGO, COMPANHIA, CODIGOORIGEM, CODIGODESTINO, CODESHARE, PARADAS, EQUIPAMENTO, ASSENTOS, DATAHORA) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int resultado = 0;
		try {
			// recupera origem
			String codOrigem = voo.getOrigem().getCodigo();
			Aeroporto origem = aeroportoDao.buscarPorCodigo(codOrigem);

			// recupera destino
			String codDestino = voo.getDestino().getCodigo();
			Aeroporto destino = aeroportoDao.buscarPorCodigo(codDestino);

			try (Connection conexao = Conexao.getConexao()) {
				try (PreparedStatement comando = conexao.prepareStatement(sql)) {
					comando.setString(1, voo.getCodigo());
					comando.setString(2, voo.getCompanhiaAerea().getCodigo());
					comando.setString(3, origem.getCodigo());
					comando.setString(4, destino.getCodigo());
					comando.setString(5, voo.getCodeshare());
					comando.setInt(6, voo.getParadas());
					comando.setString(7, voo.getEquipamento());
					comando.setInt(8, voo.getNumeroDeAssentos());
					comando.setDate(9, voo.getData());
					resultado = comando.executeUpdate();
				}
			}

		} catch (Exception e) {
			throw new DaoVooException("ERRO: falha voo nao inserido");
		}
		if (resultado == 0) {
			throw new DaoVooException("ERRO: falha voo nao inserido");
		}
	}

	@Override
	public Voo buscarPorCodigo(Integer codigo) throws DaoVooException {

		return null;
	}

	@Override
	public List<Voo> buscarTodos() throws DaoVooException {
		List<Voo> lista = new ArrayList<>();
		
		CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
		AeroportoDao aeroportoDao = new AeroportoDaoDerby();

		String sql = "SELECT * FROM VOO";

		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comandoVoos = conexao.createStatement()) {
				try (ResultSet resultadoVoos = comandoVoos.executeQuery(sql)) {
					// Para cada linha da tabela voo
					while (resultadoVoos.next()) {
						Voo voo = new Voo(
								resultadoVoos.getString("CODIGO"), 
								companhiaAereaDao.buscarPorCodigo(resultadoVoos.getString("COMPANHIA")), 
								aeroportoDao.buscarPorCodigo(resultadoVoos.getString("CODIGOORIGEM")), 
								aeroportoDao.buscarPorCodigo(resultadoVoos.getString("CODIGODESTINO")), 
								resultadoVoos.getString("CODESHARE"), 
								resultadoVoos.getInt("PARADAS"), 
								resultadoVoos.getString("EQUIPAMENTO"), 
								resultadoVoos.getInt("ASSENTOS"), 
								resultadoVoos.getDate("DATAHORA")
						);
						lista.add(voo);
					}
				}
				return lista;
			}
		} catch (Exception e) {
            throw new DaoVooException("Falha na busca: " + e.getMessage(), e);
        }
	}

	@Override
	public List<Aeroporto> buscarOrigem() throws DaoVooException {
		List<Aeroporto> lista = new ArrayList<>();
		
		CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
		AeroportoDao aeroportoDao = new AeroportoDaoDerby();

		String sql = "SELECT * FROM VOO";

		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comandoVoos = conexao.createStatement()) {
				try (ResultSet resultadoVoos = comandoVoos.executeQuery(sql)) {
					// Para cada linha da tabela voo
					while (resultadoVoos.next()) {
						Voo voo = new Voo(
								resultadoVoos.getString("CODIGO"), 
								companhiaAereaDao.buscarPorCodigo(resultadoVoos.getString("COMPANHIA")), 
								aeroportoDao.buscarPorCodigo(resultadoVoos.getString("CODIGOORIGEM")), 
								aeroportoDao.buscarPorCodigo(resultadoVoos.getString("CODIGODESTINO")), 
								resultadoVoos.getString("CODESHARE"), 
								resultadoVoos.getInt("PARADAS"), 
								resultadoVoos.getString("EQUIPAMENTO"), 
								resultadoVoos.getInt("ASSENTOS"), 
								resultadoVoos.getDate("DATAHORA")
						);
						lista.add(voo.getOrigem());
					}
					return lista;
				}
			}
		} catch (Exception e) {
            throw new DaoVooException("Falha na busca: " + e.getMessage(), e);
        }
	}

	@Override
	public List<Aeroporto> buscarDestino(String origem) throws DaoVooException {
		List<Aeroporto> lista = new ArrayList<>();
		
		CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
		AeroportoDao aeroportoDao = new AeroportoDaoDerby();

		String sql = "SELECT * FROM VOO";

		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comandoVoos = conexao.createStatement()) {
				try (ResultSet resultadoVoos = comandoVoos.executeQuery(sql)) {
					// Para cada linha da tabela voo
					while (resultadoVoos.next()) {
						Voo voo = new Voo(
								resultadoVoos.getString("CODIGO"), 
								companhiaAereaDao.buscarPorCodigo(resultadoVoos.getString("COMPANHIA")), 
								aeroportoDao.buscarPorCodigo(resultadoVoos.getString("CODIGOORIGEM")), 
								aeroportoDao.buscarPorCodigo(resultadoVoos.getString("CODIGODESTINO")), 
								resultadoVoos.getString("CODESHARE"), 
								resultadoVoos.getInt("PARADAS"), 
								resultadoVoos.getString("EQUIPAMENTO"), 
								resultadoVoos.getInt("ASSENTOS"), 
								resultadoVoos.getDate("DATAHORA")
						);
						if(voo.getOrigem().getNome().equals(origem))
							lista.add(voo.getDestino());
					}
					return lista;
				}
			}
		} catch (Exception e) {
            throw new DaoVooException("Falha na busca: " + e.getMessage(), e);
        }
	}
}
