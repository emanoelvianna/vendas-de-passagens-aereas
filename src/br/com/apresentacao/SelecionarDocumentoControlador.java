package br.com.apresentacao;

import java.util.ArrayList;
import java.util.List;

import br.com.negocio.NegocioFachada;
import br.com.negocio.enumeracao.Documento;

public class SelecionarDocumentoControlador {
	private NegocioFachada fachada;

	public SelecionarDocumentoControlador() {
		fachada = new NegocioFachada();
	}

	private List<String> toListString(Documento[] listaOrigem) {
		List<String> listaDestino = new ArrayList<String>(listaOrigem.length);
		for (Documento documento : listaOrigem) {
			listaDestino.add(documento.toString());
		}
		return listaDestino;
	}

	public List<String> getDocumentos() {
		return toListString(fachada.getListaDeDocumentos());
	}
}
