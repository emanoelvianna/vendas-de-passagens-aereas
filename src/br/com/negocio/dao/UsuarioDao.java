package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Usuario;
import br.com.negocio.excecoes.DaoUsuarioException;

public interface UsuarioDao {
	public void inserir(Usuario usuario) throws DaoUsuarioException;

	public Usuario buscarPorCodigo(String codigo) throws DaoUsuarioException;

	public List<Usuario> buscarTodos() throws DaoUsuarioException;
}
