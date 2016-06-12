package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.modelo.entidades.Destino;
import br.com.persistencia.conexao.Conexao;
import br.com.persistencia.dao.DestinoDao;
import br.com.persistencia.excecoes.DaoDestinoException;

public class DestinoDaoDerby implements DestinoDao {

	@Override
	public void inserir(Destino destino) throws DaoDestinoException {
		String sql = "INSERT INTO DESTINO(CODIGO, NOME) VALUES(?, ?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, destino.getCodigo());
				comando.setString(2, destino.getNome());
				resultado = comando.executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoDestinoException("ERRO: falha ao tentar inserir destino", e);
		}
		if (resultado == 0) {
			throw new DaoDestinoException("ERRO: falha destino não inserido");
		}
	}

	@Override
	public Destino buscarPorCodigo(Integer codigo) throws DaoDestinoException {
		Destino destino = null;
		String sql = "SELECT * FROM DESTINO WHERE CODIGO = ?";
		
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setInt(1, codigo);
				try (ResultSet resultado = comando.executeQuery(sql)) {
					if(resultado.next()) {
						destino = new Destino(
								resultado.getString("codigo"),
								resultado.getString("nome")
						);
					}
					return destino;
				}
			}
		} catch (Exception e) {
			throw new DaoDestinoException("ERRO: falha ao tentar inserir usúario", e);
		}
	}

}
