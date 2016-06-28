package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Usuario;
import br.com.negocio.excecoes.DaoUsuarioException;

public interface UsuarioDao {
	public void inserir(Usuario usuario);

	public Usuario buscarPorCodigo(String codigo);

	public List<Usuario> buscarTodos();
	
	public Usuario validaUsuario(String login, String senha);
}
