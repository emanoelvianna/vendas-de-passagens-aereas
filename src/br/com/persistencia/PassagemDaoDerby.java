package br.com.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.modelo.entidades.CompanhiaAerea;
import br.com.modelo.entidades.Passagem;
import br.com.modelo.entidades.Usuario;
import br.com.persistencia.conexao.Conexao;
import br.com.persistencia.dao.CompanhiaAereaDao;
import br.com.persistencia.dao.PassagemDao;
import br.com.persistencia.dao.UsuarioDao;
import br.com.persistencia.excecoes.DaoPassagemException;

public class PassagemDaoDerby implements PassagemDao {

	private CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
	private UsuarioDao usuarioDao = new UsuarioDaoDerby();

	@Override
	public void inserir(Passagem passagem) throws DaoPassagemException {
		String sql = "INSERT INTO PASSAGEM(CODIGO, CODIGOUSUARIO, COMPANHIA, NOMEPASSAGEIRO, STATUS, LIBERARCHECKIN, DATAHORA, ASSENTO, DOCUMENTO, LOCALIZADOR) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {

			CompanhiaAerea companhiaAerea = companhiaAereaDao.buscarPorCodigo(passagem.getCompanhiaAerea());
			Usuario usuario = usuarioDao.buscarPorCodigo(passagem.getCodigoUsuario());

			try (PreparedStatement statement = conexao.prepareStatement(sql)) {
				statement.setString(1, passagem.getCodigo());
				statement.setString(2, usuario.getCodigo());
				statement.setString(3, companhiaAerea.getCodigo());
				statement.setString(4, passagem.getNomePassageiro());
				statement.setString(5, passagem.getStatus().toString());
				statement.setInt(6, passagem.getCheckin());
				statement.setDate(7, (Date) passagem.getDatahora());
				statement.setInt(8, passagem.getNumeroAssento());
				statement.setString(9, passagem.getDocumento().toString());
				statement.setInt(10, passagem.getNumeroLocalizador());
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
