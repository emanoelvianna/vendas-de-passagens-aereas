package br.com.apresentacao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import br.com.negocio.NegocioFachada;
import br.com.negocio.entidade.Aeroporto;

public class ComprarAeroportoControlador {
	private NegocioFachada fachada;

	public ComprarAeroportoControlador() {
		fachada = new NegocioFachada();
	}

	private List<String> toListString(List<Aeroporto> listaOrigem) {
		List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
		for (Aeroporto aeroporto : listaOrigem) {
			listaDestino.add(aeroporto.getNome());
		}
		return listaDestino;
	}

	public List<String> getOrigem() {
		return toListString(fachada.buscarAeroportosOrigem());
	}

	public List<String> getDestino(String origem) {
		return toListString(fachada.buscarAeroportosDestino(origem));
	}

}
