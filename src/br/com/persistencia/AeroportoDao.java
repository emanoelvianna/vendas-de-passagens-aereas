package br.com.persistencia;

import java.util.List;

import br.com.entidades.Aeroporto;

public interface AeroportoDao {
	
	public boolean inserir(Aeroporto rota) throws DaoAeroportoException;

	public Aeroporto buscarPorCodigo(String codigo);

	public List<Aeroporto> buscarTodos() throws DaoAeroportoException;

}
