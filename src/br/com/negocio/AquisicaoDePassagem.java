package br.com.negocio;

import org.joda.time.DateTime;

import br.com.negocio.dao.PassagemDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Passagem;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.TipoPassagem;
import br.com.persistencia.PassagemDaoDerby;

public class AquisicaoDePassagem {
	private double valorPassagem = 250.00;
	private PassagemDao passagemDao = null;

	public void comprar(String nome, Documento documento, TipoPassagem tipoPassagem, Aeroporto origem,
			Aeroporto destino, DateTime dataHora) {
		passagemDao = new PassagemDaoDerby();

	}

	private double calculaDesconto(TipoPassagem tipoPassagem) {
		CalculaPassagemSingleton calculaPassagemSingleton = CalculaPassagemSingleton.getCalculoIrpfSingleton();
		CalculaPassagem calcula = calculaPassagemSingleton.createInstance(tipoPassagem);
		return calcula.descontoPromocao(valorPassagem);
	}

}
