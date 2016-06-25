package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.excecoes.DaoAeroportoException;

public interface AeroportoDao {
	public void inserir(Aeroporto aeroporto) throws DaoAeroportoException;

	public Aeroporto buscarPorCodigo(String codigo) throws DaoAeroportoException;

	public List<Aeroporto> buscarTodos() throws DaoAeroportoException;
}
