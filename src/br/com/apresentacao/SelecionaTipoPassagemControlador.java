package br.com.apresentacao;

import java.util.ArrayList;
import java.util.List;

import br.com.negocio.NegocioFachada;
import br.com.negocio.enumeracao.TipoPassagem;

public class SelecionaTipoPassagemControlador {
	private NegocioFachada fachada;

	public SelecionaTipoPassagemControlador() {
		fachada = new NegocioFachada();
	}

	private List<String> toListString(TipoPassagem[] listaOrigem) {
		List<String> listaDestino = new ArrayList<String>(listaOrigem.length);
		for (TipoPassagem tipoPassagem : listaOrigem) {
			listaDestino.add(tipoPassagem.toString());
		}
		return listaDestino;
	}

	public List<String> getTipoPassagem() {
		return toListString(fachada.getTipoPassagem());
	}
}
