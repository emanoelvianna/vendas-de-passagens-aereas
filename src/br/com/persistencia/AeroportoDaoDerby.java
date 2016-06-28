package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.excecoes.DaoAeroportoException;
import br.com.persistencia.conexao.Conexao;

public class AeroportoDaoDerby implements AeroportoDao {

	@Override
	public void inserir(Aeroporto aeroporto) {
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
		}catch (DaoAeroportoException e) {
			new DaoAeroportoException("ERRO: falha ao tentar inserir o Aeroporto", e);
		}catch (Exception e) {
			new DaoAeroportoException("ERRO: falha ao tentar inserir o Aeroporto", e);
		}
		if (resultado == 0) {
			new DaoAeroportoException("ERRO: falha Aeroporto não inserido");
		}
	}

	@Override
	public Aeroporto buscarPorCodigo(String codigo) {
		 String sql = "SELECT * FROM AEROPORTO WHERE CODIGO = ?";
	        Aeroporto aeroporto = null;
	        try (Connection conexao = Conexao.getConexao()) {
	            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
	                comando.setString(1, codigo);
	                try (ResultSet resultado = comando.executeQuery()) {
	                    if (resultado.next()) {
	                    	aeroporto = new Aeroporto(
	                    			resultado.getString("codigo"),
	                    			resultado.getString("latitude"),
	                    			resultado.getString("longitude"),
	                    			resultado.getString("nome")
	                        );
	                    }
	                    return aeroporto;
	                }
	            }
	        }catch (DaoAeroportoException e) {
				new DaoAeroportoException("ERRO: falha ao tentar buscar pelo código do Aeroporto", e);
			}catch (Exception e) {
				new DaoAeroportoException("ERRO: falha ao tentar buscar pelo código do Aeroporto", e);
			}
			return aeroporto;
	}

	@Override
	public List<Aeroporto> buscarTodos(){
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
		 }catch (DaoAeroportoException e) {
			 new DaoAeroportoException("ERRO: falha ao tentar buscar todos os Aeroportos", e);
		 }catch (Exception e) {
			 new DaoAeroportoException("ERRO: falha ao tentar buscar todos os Aeroportos", e);
		 }
		return lista;
	}

	@Override
	public Aeroporto buscarPorNome(String n) {
		AeroportoDaoDerby aeroportoDaoDerby = new AeroportoDaoDerby();
		List<Aeroporto> lista = aeroportoDaoDerby.buscarTodos();
		for (Aeroporto aeroporto : lista) {
			if(aeroporto.getNome().equals(n))
				return aeroporto;
		}
		return null;
	}
}
