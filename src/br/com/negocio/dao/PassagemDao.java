package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Passagem;

public interface PassagemDao {
	public void inserir(Passagem passagem);
	
	public Passagem buscarPeloCodigoDoUsuario(String codigo);

	public List<Passagem> buscarTodos();
}
