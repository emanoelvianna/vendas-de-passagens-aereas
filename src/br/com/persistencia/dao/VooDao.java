package br.com.persistencia.dao;

import java.util.List;

import br.com.modelo.entidades.Voo;
import br.com.persistencia.excecoes.DaoVooException;

public interface VooDao {
	public void inserir(Voo voo) throws DaoVooException;

	public Voo buscarPorCodigo(Integer codigo) throws DaoVooException;

	public List<Voo> buscarTodos() throws DaoVooException;
}
