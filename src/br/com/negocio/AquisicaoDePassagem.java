package br.com.negocio;

import java.sql.Timestamp;
import java.util.List;

import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.dao.PassagemDao;
import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.dao.VooDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.CompanhiaAerea;
import br.com.negocio.entidade.Passagem;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.entidade.Voo;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.Status;
import br.com.negocio.enumeracao.TipoPassagem;
import br.com.persistencia.AeroportoDaoDerby;
import br.com.persistencia.CompanhiaAereaDaoDerby;
import br.com.persistencia.PassagemDaoDerby;
import br.com.persistencia.UsuarioDaoDerby;
import br.com.persistencia.VooDaoDerby;

public class AquisicaoDePassagem {
	private AeroportoDao aeroportoDao;
	private PassagemDao passagemDao;
	private double valorPassagem = 900.00;
	private CompanhiaAereaDao companhiaAereaDaoDerby;
	private CompanhiaAerea companhiaAerea;
	private UsuarioDao usuarioDao;

	public AquisicaoDePassagem() {
		companhiaAereaDaoDerby = new CompanhiaAereaDaoDerby();
		companhiaAerea = companhiaAereaDaoDerby.buscarPorCodigo("ACME"); 
		aeroportoDao = new AeroportoDaoDerby();
		passagemDao = new PassagemDaoDerby();
		usuarioDao = new UsuarioDaoDerby();
	}

	public int comprarPassagem(String nome, Documento documento, Timestamp data, String origem, String destino, String codigoUsuario,
			TipoPassagem t) {
		
		Usuario usuario = usuarioDao.buscarPorCodigo(codigoUsuario);

		Aeroporto aeroportoOrigem = aeroportoDao.buscarPorNome(origem);
		Aeroporto aeroportoDestino = aeroportoDao.buscarPorNome(destino);
		
		VooDaoDerby daoDerby = new VooDaoDerby();
		List<Voo> voos = daoDerby.buscarVoosPorOrigemDestin(aeroportoOrigem.getCodigo(), aeroportoDestino.getCodigo());

		GeraNumeroLocalizadorSingleton geraNumeroLocalizadorSingleton = GeraNumeroLocalizadorSingleton.getGeraNumeroLocalizadorSingleton();
		int numeroLocalizador = geraNumeroLocalizadorSingleton.gerarNumeroLocalizador();

		CalculaPassagemSingleton calculaPassagemSingleton = CalculaPassagemSingleton.getCalculoIrpfSingleton();
		CalculaPassagem calculaPassagem = calculaPassagemSingleton.createInstance(t);
		double valor = calculaPassagem.descontoPromocao(valorPassagem);

		Passagem passagem = new Passagem(usuario, companhiaAerea, nome, Status.PENDENTE, 0, data, -1, documento, numeroLocalizador, valor, voos);

		passagemDao.inserir(passagem);
	
		return numeroLocalizador;
	}
}
