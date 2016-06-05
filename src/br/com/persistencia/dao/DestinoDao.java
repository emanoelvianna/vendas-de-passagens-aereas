package br.com.persistencia.dao;

import br.com.modelo.entidades.Destino;
import br.com.persistencia.excecoes.DaoDestinoException;

public interface DestinoDao {
	public void inserir(Destino Destino) throws DaoDestinoException;

	public Destino buscarPorCodigo(Integer codigo) throws DaoDestinoException;

}
