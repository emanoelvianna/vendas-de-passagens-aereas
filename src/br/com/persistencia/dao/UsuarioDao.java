package br.com.persistencia.dao;

import java.util.List;

import br.com.modelo.entidades.Usuario;
import br.com.persistencia.excecoes.DaoUsuarioException;

public interface UsuarioDao {
	public void inserir(Usuario usuario) throws DaoUsuarioException;

	public Usuario buscarPorCodigo(Integer codigo) throws DaoUsuarioException;

	public List<Usuario> buscarTodos() throws DaoUsuarioException;
}
