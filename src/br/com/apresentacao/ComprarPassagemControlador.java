package br.com.apresentacao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import br.com.negocio.NegocioFachada;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Voo;

public class ComprarPassagemControlador {
	private NegocioFachada fachada;

	public ComprarPassagemControlador() {
		fachada = new NegocioFachada();
	}
	
	

	private List<String> toListString(List<Aeroporto> listaOrigem) {
		List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
		for (Aeroporto aeroporto : listaOrigem) {
			listaDestino.add(aeroporto.getNome());
		}
		return listaDestino;
	}
	
	private List<String> toListStringDate(List<Voo> listaOrigem) {
		List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
		for (Voo voo : listaOrigem) {
			listaDestino.add(voo.getData().toString());
		}
		return listaDestino;
	}

	public List<String> getOrigem() {
		return toListString(fachada.buscarAeroportosOrigem());
	}

	public List<String> getDestino(String origem) {
		return toListString(fachada.buscarAeroportosDestino(origem));
	}

	public List<String> getData(String voo) {
		return fachada.buscarDatasVoo(voo);
	}



	public void comprar(String nome, String documento, String tipoPassagem, String aeroportoOrigem, String aeroportoDestino, String data) throws ParseException {
		fachada.comprarPassagem(nome, documento, tipoPassagem, aeroportoOrigem, aeroportoDestino, data);
	}
}
