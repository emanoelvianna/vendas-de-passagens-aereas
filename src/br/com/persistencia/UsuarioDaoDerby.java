package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.entidades.Usuario;
import br.com.persistencia.conexao.Conexao;
import br.com.persistencia.dao.UsuarioDao;
import br.com.persistencia.excecoes.DaoUsuarioException;

public class UsuarioDaoDerby implements UsuarioDao {

	@Override
	public void inserir(Usuario usuario) throws DaoUsuarioException {
		String sql = "INSERT INTO USUARIO(CODIGO, LOGIN, SENHA) VALUES(?,?,?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement statement = conexao.prepareStatement(sql)) {
				statement.setString(1, usuario.getCodigo());
				statement.setString(2, usuario.getLogin());
				statement.setString(3, usuario.getSenha());
				resultado = statement.executeUpdate();
			}
		} catch (Exception e) {
			throw new DaoUsuarioException("ERRO: falha ao tentar inserir usúario", e);
		}
		if (resultado == 0) {
			throw new DaoUsuarioException("ERRO: falha usúario não inserido");
		}
	}

    @Override
    public Usuario buscarPorCodigo(String codigo) throws DaoUsuarioException {
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
        } catch (Exception e) {
            throw new DaoUsuarioException("Falha na busca", e);
        }
    }

	@Override
	public List<Usuario> buscarTodos() throws DaoUsuarioException {
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
		} catch (Exception e) {
			throw new DaoUsuarioException("ERRO: falha ao tentar inserir usúario", e);
		}
	}

}
