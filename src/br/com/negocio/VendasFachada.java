package br.com.negocio;

import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.TipoPassagem;

public class VendasFachada {

	private AquisicaoDePassagem aquisicaoDePassagem;

	public void comprarPassagem(String nome, Documento documento, TipoPassagem tipoPassagem, Aeroporto origem) {
		aquisicaoDePassagem = new AquisicaoDePassagem();
		// comprar passagem
	}

}
