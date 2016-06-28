package br.com.negocio.dao;

import java.util.List;

import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.excecoes.DaoAeroportoException;

public interface AeroportoDao {
	public void inserir(Aeroporto aeroporto);

	public Aeroporto buscarPorCodigo(String codigo);
	
	public Aeroporto buscarPorNome(String nome);

	public List<Aeroporto> buscarTodos();
}
