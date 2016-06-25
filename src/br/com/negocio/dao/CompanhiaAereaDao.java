package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.CompanhiaAerea;
import br.com.negocio.excecoes.DaoCompanhiaAereaException;
import br.com.negocio.excecoes.DaoUsuarioException;

public interface CompanhiaAereaDao {
	public void inserir(CompanhiaAerea companhiaAerea) throws DaoCompanhiaAereaException;

	public List<CompanhiaAerea> buscarTodos() throws DaoCompanhiaAereaException;
	
	public CompanhiaAerea buscarPorCodigo(String codigo) throws DaoUsuarioException;
}
