package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.CompanhiaAerea;
import br.com.negocio.excecoes.DaoCompanhiaAereaException;
import br.com.negocio.excecoes.DaoUsuarioException;

public interface CompanhiaAereaDao {
	public void inserir(CompanhiaAerea companhiaAerea);

	public List<CompanhiaAerea> buscarTodos();
	
	public CompanhiaAerea buscarPorCodigo(String codigo);
}
