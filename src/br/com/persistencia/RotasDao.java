package br.com.persistencia;

import java.util.List;

import br.com.entidades.Rota;

public interface RotasDao {

	public boolean inserir(Rota rota);

	public Rota buscarPorCodigo(String codigo);

	public List<Rota> buscarTodasAsRotas();
}
