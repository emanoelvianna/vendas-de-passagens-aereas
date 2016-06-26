package br.com.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.negocio.CompanhiaAerea;
import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.dao.PassagemDao;
import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.entidade.Passagem;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.excecoes.DaoPassagemException;
import br.com.persistencia.conexao.Conexao;

public class PassagemDaoDerby implements PassagemDao {

	private CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
	private UsuarioDao usuarioDao = new UsuarioDaoDerby();

	@Override
	public void inserir(Passagem passagem) throws DaoPassagemException {
		String sql = "INSERT INTO PASSAGEM(CODIGOUSUARIO, COMPANHIA, NOMEPASSAGEIRO, STATUS, LIBERARCHECKIN, DATAHORA, ASSENTO, DOCUMENTO, LOCALIZADOR, VALOR) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {

			CompanhiaAerea companhiaAerea = companhiaAereaDao.buscarPorCodigo("ACME");
			Usuario usuario = usuarioDao.buscarPorCodigo(passagem.getCodigoUsuario());

			try (PreparedStatement statement = conexao.prepareStatement(sql)) {
				statement.setString(1, usuario.getCodigo());
				statement.setString(2, companhiaAerea.getCodigo());
				statement.setString(3, passagem.getNomePassageiro());
				statement.setString(4, passagem.getStatus().toString());
				statement.setInt(5, passagem.getCheckin());
				statement.setString(6, passagem.getDatahora().toString());
				statement.setInt(7, passagem.getNumeroAssento());
				statement.setString(8, passagem.getDocumento().toString());
				statement.setInt(9, passagem.getNumeroLocalizador());
				statement.setDouble(10, passagem.getValor());
				resultado = statement.executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoPassagemException("ERRO: falha ao tentar inserir passagem", e);
		}
		if (resultado == 0) {
			throw new DaoPassagemException("ERRO: falha passagem não inserido");
		}

	}

	@Override
	public Passagem buscarPorCodigo(Integer codigo) throws DaoPassagemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passagem> buscarTodos() throws DaoPassagemException {
		// TODO Auto-generated method stub
		return null;
	}
}
