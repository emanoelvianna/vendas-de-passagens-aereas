package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.entidade.CompanhiaAerea;
import br.com.negocio.excecoes.DaoCompanhiaAereaException;
import br.com.negocio.excecoes.DaoUsuarioException;
import br.com.persistencia.conexao.Conexao;

public class CompanhiaAereaDaoDerby implements CompanhiaAereaDao {

	public void inserir(CompanhiaAerea companhiaAerea) {
		String sql = "INSERT INTO COMPANHIA(codigo,nome) VALUES(?,?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, companhiaAerea.getCodigo());
				comando.setString(2, companhiaAerea.getNome());
				resultado = comando.executeUpdate();
			}
		}catch (DaoCompanhiaAereaException d) {
        	new DaoUsuarioException("Erro: tentativa de inserir companhia aerea falhou" + d);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de inserir companhia aerea falhou" + e);
        }
		if (resultado == 0) {
			new DaoCompanhiaAereaException("ERRO: falha companhia aerea nao inserida");
		}
	}

    @Override
    public CompanhiaAerea buscarPorCodigo(String codigo) {
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
        }catch (DaoCompanhiaAereaException d) {
        	new DaoUsuarioException("Erro: tentativa de bucar companhia aerea falhou" + d);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de bucar companhia aerea falhou" + e);
        }
		return companhiaAerea;
    }

	public List<CompanhiaAerea> buscarTodos(){
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
		}catch (DaoCompanhiaAereaException d) {
        	new DaoUsuarioException("Erro: tentativa de bucar companhia aerea falhou" + d);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de bucar companhia aerea falhou" + e);
        }
		return lista;
	}
}
