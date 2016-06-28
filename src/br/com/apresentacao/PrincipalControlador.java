package br.com.apresentacao;

import java.util.ArrayList;
import java.util.List;

import br.com.negocio.NegocioFachada;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.TipoPassagem;

public class PrincipalControlador {

	NegocioFachada fachada = new NegocioFachada();

	public boolean login(String login, String senha) {
		boolean eValido = fachada.loginUsuario(login, senha);
		if (eValido == true)
			return true;
		return false;
	}

	private List<String> toListStringDocumento(Documento[] documentos) {
		List<String> listaDestino = new ArrayList<String>(documentos.length);
		for (Documento d : documentos) {
			listaDestino.add(d.toString());
		}
		return listaDestino;
	}

	private List<String> toListStringTipoPassagem(TipoPassagem[] tipoPassagems) {
		List<String> listaDestino = new ArrayList<String>(tipoPassagems.length);
		for (TipoPassagem t : tipoPassagems) {
			listaDestino.add(t.toString());
		}
		return listaDestino;
	}

	private List<String> toListStringAeroporto(List<Aeroporto> listaOrigem) {
		List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
		for (Aeroporto aeroporto : listaOrigem) {
			listaDestino.add(aeroporto.getNome());
		}
		return listaDestino;
	}
	
	public int comprarPassagem(String nome, String documento, String data, String origem, String destino, String tipoPassagem) {
		int localizador = fachada.comprarPassagem(nome, documento, data, origem, destino, tipoPassagem);
		return localizador;
	}

	public List<String> buscarDocumentos() {
		return toListStringDocumento(fachada.buscarDocumentos());
	}

	public List<String> buscarTipoPassagem() {
		return toListStringTipoPassagem(fachada.buscarTipoPassagem());
	}

	public List<String> getOrigem() {
		return toListStringAeroporto(fachada.buscarAeroportosOrigem());
	}

	public List<String> getDestino(String origem) {
		return toListStringAeroporto(fachada.buscarAeroportosDestino(origem));
	}

	public List<String> getData(String voo) {
		return fachada.buscarDatasVoo(voo);
	}

	public void criarBaseDeDados() {
		fachada.criarBaseDeDados();
	}
}
