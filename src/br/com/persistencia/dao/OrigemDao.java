package br.com.persistencia.dao;

import br.com.modelo.entidades.Origem;
import br.com.persistencia.excecoes.DaoOrigemException;

public interface OrigemDao {
	public void inserir(Origem origem) throws DaoOrigemException;

	public Origem buscarPorCodigo(String codigo) throws DaoOrigemException;

}
