package br.com.persistencia.dao;

import java.util.List;

import br.com.modelo.entidades.CompanhiaAerea;
import br.com.persistencia.excecoes.DaoCompanhiaAereaException;

public interface CompanhiaAereaDao {
	public void inserir(CompanhiaAerea companhiaAerea) throws DaoCompanhiaAereaException;

	public List<CompanhiaAerea> buscarTodos() throws DaoCompanhiaAereaException;
}
