package br.com.persistencia.dao;

import java.util.List;

import br.com.modelo.entidades.Aeroporto;
import br.com.persistencia.excecoes.DaoAeroportoException;

public interface AeroportoDao {
	public void inserir(Aeroporto aeroporto) throws DaoAeroportoException;

	public Aeroporto buscarPorCodigo(String codigo) throws DaoAeroportoException;

	public List<Aeroporto> buscarTodos() throws DaoAeroportoException;
}
