package br.com.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.dao.PassagemDao;
import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Passagem;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.Status;
import br.com.negocio.enumeracao.TipoPassagem;
import br.com.negocio.excecoes.DaoPassagemException;
import br.com.negocio.excecoes.DaoVooException;
import br.com.persistencia.AeroportoDaoDerby;
import br.com.persistencia.PassagemDaoDerby;
import br.com.persistencia.PersistirDados;
import br.com.persistencia.UsuarioDaoDerby;
import br.com.persistencia.VooDaoDerby;
import br.com.persistencia.conexao.Conexao;

public class NegocioFachada {
	private double valorPassagem = 900;
	private PassagemDao passagemDao = null;
	private Passagem passagem;
	private Usuario usuario;
	private VooDaoDerby vooDaoDerby;
	
	public NegocioFachada() {
		passagemDao = new PassagemDaoDerby();
		vooDaoDerby = new VooDaoDerby();
	}

	public void login(String login, String senha) {
		UsuarioDao usuarioDao = new UsuarioDaoDerby();
		usuario = usuarioDao.validarUsuario(login, senha);
	}

	public int comprarPassagem(String nomePassageiro, Documento documento, TipoPassagem tipoPassagem, Aeroporto origem, Aeroporto destino,
			DateTime dataHora) {

		GeraNumeroLocalizadorSingleton geraNumeroLocalizadorSingleton = GeraNumeroLocalizadorSingleton.getGeraNumeroLocalizadorSingleton();
		int numeroLocalizador = geraNumeroLocalizadorSingleton.gerarNumeroLocalizador();
		double valorPassagem = calculaDesconto(tipoPassagem);
		passagem = new Passagem(nomePassageiro, Status.PENDENTE, dataHora, 0, numeroLocalizador, documento, 0, usuario.getCodigo(), valorPassagem);
		try {
			passagemDao.inserir(passagem);
		} catch (DaoPassagemException daoPassagemException) {
			System.out.println("Erro ao tenatr inserir a passagem comprada no banco de dados" + daoPassagemException);
		}
		return numeroLocalizador;
	}

	private double calculaDesconto(TipoPassagem tipoPassagem) {
		CalculaPassagemSingleton calculaPassagemSingleton = CalculaPassagemSingleton.getCalculoIrpfSingleton();
		CalculaPassagem calcula = calculaPassagemSingleton.createInstance(tipoPassagem);
		return calcula.descontoPromocao(valorPassagem);
	}

	public void criarBaseDeDados() {
		System.out.println("-- Criando a base de dados --");
		try {
			Conexao.criarBd();
			PersistirDados dados = new PersistirDados();
			dados.lerTodosOsArquivos();
			System.out.println("-- Base de dados criada --");
		} catch (SQLException exception) {
			System.out.println("Erro ao tentar criar a base de dados! " + exception);
		} catch (Exception exception) {
			System.out.println("Erro ao tentar criar a base de dados! " + exception);
		}
	}

	public List<Aeroporto> buscarAeroportosOrigem() {
		List<Aeroporto> lista = new ArrayList<>();
		try {
			lista = vooDaoDerby.buscarOrigem();
		} catch (DaoVooException e) {
			new DaoVooException("Erro: não conseguiu buscar lista de aeroportos", e);
		}
		return lista;
	}

	public List<Aeroporto> buscarAeroportosDestino(String origem) {
		List<Aeroporto> lista = new ArrayList<>();
		try {
			lista = vooDaoDerby.buscarDestino(origem);
		} catch (DaoVooException e) {
			new DaoVooException("Erro: não conseguiu buscar lista de aeroportos", e);
		}
		return lista;
	}

	public Documento[] getListaDeDocumentos() {
		return Documento.values();
	}

	public TipoPassagem[] getTipoPassagem() {
		return TipoPassagem.values();
	}
	
	public static void main(String[] args) {
		NegocioFachada fachada = new NegocioFachada();
		List<Aeroporto> buscarAeroportosOrigem = fachada.buscarAeroportosDestino("Sochi");
		for (Aeroporto aeroporto : buscarAeroportosOrigem) {
			System.out.println(aeroporto.getNome());
		}
	}
}
