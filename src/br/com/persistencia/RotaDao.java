package br.com.persistencia;

import java.util.List;

import br.com.entidades.Rota;

public interface RotaDao {

	public boolean inserir(Rota rota);

	public Rota buscarPorCodigo(String codigo);

	public List<Rota> buscarTodasAsRotas();

	public Rota buscarPorDestino(String origem);

	public Rota buscarPorOrigem(String destino);

	public Rota buscarPorCompanhiaAerea(String companhiaAerea);
}
