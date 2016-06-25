package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Voo;
import br.com.negocio.excecoes.DaoVooException;

public interface VooDao {
	public void inserir(Voo voo) throws DaoVooException;

	public Voo buscarPorCodigo(Integer codigo) throws DaoVooException;

	public List<Voo> buscarTodos() throws DaoVooException;
}
