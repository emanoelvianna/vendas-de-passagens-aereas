package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.modelo.entidades.Destino;
import br.com.modelo.entidades.Origem;
import br.com.persistencia.conexao.Conexao;
import br.com.persistencia.dao.DestinoDao;
import br.com.persistencia.dao.OrigemDao;
import br.com.persistencia.excecoes.DaoDestinoException;
import br.com.persistencia.excecoes.DaoOrigemException;

public class OrigemDaoDerby implements OrigemDao {

	@Override
	public void inserir(Origem origem) throws DaoOrigemException {
		String sql = "INSERT INTO ORIGEM(CODIGO, NOME) VALUES(?, ?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, origem.getCodigo());
				comando.setString(2, origem.getNome());
				resultado = comando.executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoOrigemException("ERRO: falha ao tentar inserir destino", e);
		}
		if (resultado == 0) {
			throw new DaoOrigemException("ERRO: falha destino não inserido");
		}
	}

	@Override
	public Origem buscarPorCodigo(String codigo) throws DaoOrigemException {
		Origem origem = null;
		String sql = "SELECT * FROM ORIGEM WHERE CODIGO = ?";
		
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, codigo);
				try (ResultSet resultado = comando.executeQuery(sql)) {
					if(resultado.next()) {
						origem = new Origem(
								resultado.getString("codigo"),
								resultado.getString("nome")
						);
					}
					return origem;
				}
			}
		} catch (Exception e) {
			throw new DaoOrigemException("ERRO: falha ao tentar inserir usúario", e);
		}
	}

}
