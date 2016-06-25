package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Passagem;
import br.com.negocio.excecoes.DaoPassagemException;

public interface PassagemDao {
	public void inserir(Passagem passagem) throws DaoPassagemException;

	public Passagem buscarPorCodigo(Integer codigo) throws DaoPassagemException;

	public List<Passagem> buscarTodos() throws DaoPassagemException;
}
