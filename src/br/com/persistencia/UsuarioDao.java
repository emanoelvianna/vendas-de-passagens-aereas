package br.com.persistencia;

import java.util.List;

import br.com.entidades.Usuario;

public interface UsuarioDao {
	public void inserir(Usuario usuario) throws DaoUsuarioException;

	public Usuario buscarPorCodigo(Integer codigo) throws DaoUsuarioException;

	public List<Usuario> buscarTodos() throws DaoUsuarioException;
}
