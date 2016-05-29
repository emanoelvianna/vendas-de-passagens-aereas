package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.entidades.Aeroporto;

public class AeroportoDaoDerby implements AeroportoDao {

	@Override
	public boolean inserir(Aeroporto aeroporto) throws DaoAeroportoException {
		String sql = "INSERT INTO AEROPORTO(CODIGO, LATITUDE, LONGITUDE, NOME) VALUES(?,?,?,?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement statement = conexao.prepareStatement(sql)) {
				statement.setString(1, aeroporto.getCodigo());
				statement.setString(2, aeroporto.getLatitude());
				statement.setString(3, aeroporto.getLongitude());
				statement.setString(4, aeroporto.getNome());
				resultado = statement.executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoAeroportoException("ERRO: falha ao tentar inserir usúario", e);
		}
		if (resultado == 0) {
			throw new DaoAeroportoException("ERRO: falha usúario não inserido");
		}
		return false;
	}

	@Override
	public Aeroporto buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aeroporto> buscarTodos() throws DaoAeroportoException{
		String sql = "SELECT * FROM AEROPORTO";
		List<Aeroporto> lista = new ArrayList<>();
		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comando = conexao.createStatement()) {
				try (ResultSet resultado = comando.executeQuery(sql)) {
					while (resultado.next()) {
						Aeroporto aeroporto = new Aeroporto(
								resultado.getString("codigo"), 
								resultado.getString("latitude"), 
								resultado.getString("longitude"), 
								resultado.getString("nome")
								);
						lista.add(aeroporto);
					}
					return lista;
				}
			}
		} catch (Exception e) {
			throw new DaoAeroportoException("ERRO: falha ao tentar inserir aeroporto", e);
		}
	}

}
