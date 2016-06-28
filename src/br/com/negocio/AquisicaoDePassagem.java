package br.com.negocio;

import java.sql.Timestamp;

import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.dao.PassagemDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Passagem;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.Status;
import br.com.negocio.enumeracao.TipoPassagem;
import br.com.persistencia.AeroportoDaoDerby;
import br.com.persistencia.PassagemDaoDerby;

public class AquisicaoDePassagem {
	private AeroportoDao aeroportoDao;
	private PassagemDao passagemDao;
	private double valorPassagem = 900.00;

	public AquisicaoDePassagem() {
		aeroportoDao = new AeroportoDaoDerby();
		passagemDao = new PassagemDaoDerby();
	}

	public int comprarPassagem(String nome, Documento documento, Timestamp data, String origem, String destino, String codigoUsuario,
			TipoPassagem t) {

		Aeroporto aeroportoOrigem = aeroportoDao.buscarPorNome(origem);
		Aeroporto aeroportoDestino = aeroportoDao.buscarPorNome(destino);

		GeraNumeroLocalizadorSingleton geraNumeroLocalizadorSingleton = GeraNumeroLocalizadorSingleton.getGeraNumeroLocalizadorSingleton();
		int numeroLocalizador = geraNumeroLocalizadorSingleton.gerarNumeroLocalizador();

		CalculaPassagemSingleton calculaPassagemSingleton = CalculaPassagemSingleton.getCalculoIrpfSingleton();
		CalculaPassagem calculaPassagem = calculaPassagemSingleton.createInstance(t);
		double valor = calculaPassagem.descontoPromocao(valorPassagem);

		//Passagem passagem = new Passagem(nome, Status.PENDENTE, data, 0, numeroLocalizador, documento, 0, codigoUsuario, valor);

		//passagemDao.inserir(passagem);
		
		return numeroLocalizador;
	}
}
