package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.entidade.CompanhiaAerea;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.excecoes.DaoCompanhiaAereaException;
import br.com.negocio.excecoes.DaoUsuarioException;
import br.com.persistencia.conexao.Conexao;

public class CompanhiaAereaDaoDerby implements CompanhiaAereaDao {

	public void inserir(CompanhiaAerea companhiaAerea) throws DaoCompanhiaAereaException {
		String sql = "INSERT INTO COMPANHIA(codigo,nome) VALUES(?,?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, companhiaAerea.getCodigo());
				comando.setString(2, companhiaAerea.getNome());
				resultado = comando.executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoCompanhiaAereaException("ERRO: falha ao tentar inserir companhia aérea", e);
		}
		if (resultado == 0) {
			throw new DaoCompanhiaAereaException("ERRO: falha companhia aérea não inserida");
		}
	}

    @Override
    public CompanhiaAerea buscarPorCodigo(String codigo) throws DaoUsuarioException {
        String sql = "SELECT * FROM COMPANHIA WHERE CODIGO = ?";
        CompanhiaAerea companhiaAerea = null;
        try (Connection conexao = Conexao.getConexao()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, codigo);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                    	companhiaAerea = new CompanhiaAerea(
                    			resultado.getString("codigo"),
                                resultado.getString("nome")
                        );
                    }
                    return companhiaAerea;
                }
            }
        } catch (Exception e) {
            throw new DaoUsuarioException("ERRO: falha ao tentar buscar companhia aérea", e);
        }
    }

	public List<CompanhiaAerea> buscarTodos() throws DaoCompanhiaAereaException {
		List<CompanhiaAerea> lista = new ArrayList<>();
		String sql = "SELECT * FROM COMPANHIA";

		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comando = conexao.createStatement()) {
				try (ResultSet resultado = comando.executeQuery(sql)) {
					while (resultado.next()) {
						CompanhiaAerea companhiaAerea = new CompanhiaAerea(
								resultado.getString(1),
								resultado.getString(2)
						);
						lista.add(companhiaAerea);
					}
					return lista;
				}
			}
		} catch (Exception e) {
			throw new DaoCompanhiaAereaException("ERRO: falha ao tentar buscar companhias aéreas", e);
		}
	}

}
