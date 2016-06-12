package br.com.persistencia.dao;

import java.util.List;

import br.com.modelo.entidades.Passagem;
import br.com.persistencia.excecoes.DaoPassagemException;

public interface PassagemDao {
	public void inserir(Passagem passagem) throws DaoPassagemException;

	public Passagem buscarPorCodigo(Integer codigo) throws DaoPassagemException;

	public List<Passagem> buscarTodos() throws DaoPassagemException;
}
