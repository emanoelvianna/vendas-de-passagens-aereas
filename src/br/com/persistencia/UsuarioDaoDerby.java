package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.excecoes.DaoUsuarioException;
import br.com.persistencia.conexao.Conexao;

public class UsuarioDaoDerby implements UsuarioDao {

	@Override
	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO USUARIO(CODIGO, LOGIN, SENHA) VALUES(?,?,?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement statement = conexao.prepareStatement(sql)) {
				statement.setString(1, usuario.getCodigo());
				statement.setString(2, usuario.getLogin());
				statement.setString(3, usuario.getSenha());
				resultado = statement.executeUpdate();
			}
		}catch (DaoUsuarioException daoUsuarioException) {
        	new DaoUsuarioException("Erro: tentativa de inserir usuario falhou" + daoUsuarioException);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de inserir usurio falhou" + e);
        }
		if (resultado == 0) {
			new DaoUsuarioException("ERRO: falha usuario nao inserido");
		}
	}

    @Override
    public Usuario buscarPorCodigo(String codigo) {
        String sql = "SELECT * FROM USUARIO WHERE CODIGO = ?";
        Usuario usuario = null;
        try (Connection conexao = Conexao.getConexao()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, codigo);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                    	usuario = new Usuario(
                    			resultado.getString("codigo"),
                                resultado.getString("login"),
                                resultado.getString("senha")
                        );
                    }
                    return usuario;
                }
            }
        }catch (DaoUsuarioException daoUsuarioException) {
        	new DaoUsuarioException("Erro: tentativa de buscar usuario falhou" + daoUsuarioException);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de buscar usurio falhou" + e);
        }
		return usuario;
    }

	@Override
	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM USUARIO";
		List<Usuario> lista = new ArrayList<>();
		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comando = conexao.createStatement()) {
				try (ResultSet resultado = comando.executeQuery(sql)) {
					while (resultado.next()) {
						Usuario usuario = new Usuario(
								resultado.getString("codigo"), 
								resultado.getString("login"),
								resultado.getString("senha")
						);
						lista.add(usuario);
					}
					return lista;
				}
			}
		}catch (DaoUsuarioException daoUsuarioException) {
        	new DaoUsuarioException("Erro: tentativa de buscar usuario falhou" + daoUsuarioException);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de buscar usurio falhou" + e);
        }
		return lista;
	}

	@Override
	public Usuario validaUsuario(String login, String senha) {
        String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
        Usuario usuario = null;
        try (Connection conexao = Conexao.getConexao()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, login);
                comando.setString(2, senha);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                    	usuario = new Usuario(
                    			resultado.getString("codigo"),
                                resultado.getString("login"),
                                resultado.getString("senha")
                        );
                    }
                    return usuario;
                }
            }
        }catch (DaoUsuarioException daoUsuarioException) {
        	new DaoUsuarioException("Erro: tentativa de validar usu�rio falhou" + daoUsuarioException);
        } 
        catch (Exception e) {
        	new Exception("Erro: tentativa de validar usu�rio falhou" + e);
        }
		return usuario;
	}
}
