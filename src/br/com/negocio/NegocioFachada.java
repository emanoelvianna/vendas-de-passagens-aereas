package br.com.negocio;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.TipoPassagem;
import br.com.negocio.excecoes.DaoVooException;
import br.com.persistencia.PersistirDados;
import br.com.persistencia.VooDaoDerby;
import br.com.persistencia.conexao.Conexao;

public class NegocioFachada {
	private AquisicaoDePassagem aquisicaoDePassagem;
	private LoginUsuario loginUsuario;
	private Usuario usuarioContexto;

	public NegocioFachada() {
		aquisicaoDePassagem = new AquisicaoDePassagem();
		loginUsuario = new LoginUsuario();
	}

	public int comprarPassagem(String nome, String documento, String data, String origem, String destino,
			String tipoPassagem) {
		Documento doc = Documento.valueOf(documento);
		TipoPassagem t = TipoPassagem.valueOf(tipoPassagem);
		Timestamp dat = Timestamp.valueOf(data);

		int localizador = aquisicaoDePassagem.comprarPassagem(nome, doc, dat, origem, destino, usuarioContexto.getCodigo(), t);
		return localizador;
	}

	public boolean loginUsuario(String login, String senha) {
		usuarioContexto = loginUsuario.validaLogin(login, senha);
		if (usuarioContexto != null)
			return true;
		return false;
	}

	public Documento[] buscarDocumentos() {
		return Documento.values();
	}

	public TipoPassagem[] buscarTipoPassagem() {
		return TipoPassagem.values();
	}

	public List<Aeroporto> buscarAeroportosOrigem() {
		VooDaoDerby vooDaoDerby = new VooDaoDerby();
		List<Aeroporto> lista = new ArrayList<>();
		try {
			lista = vooDaoDerby.buscarOrigem();
		} catch (DaoVooException e) {
			new DaoVooException("Erro: não conseguiu buscar lista de aeroportos", e);
		}
		return lista;
	}

	public List<Aeroporto> buscarAeroportosDestino(String origem) {
		VooDaoDerby vooDaoDerby = new VooDaoDerby();
		List<Aeroporto> lista = new ArrayList<>();
		try {
			lista = vooDaoDerby.buscarDestino(origem);
		} catch (DaoVooException e) {
			new DaoVooException("Erro: não conseguiu buscar lista de aeroportos", e);
		}
		return lista;
	}

	public List<String> buscarDatasVoo(String voo) {
		VooDaoDerby vooDaoDerby = new VooDaoDerby();
		List<String> lista = new ArrayList<>();
		try {
			lista = vooDaoDerby.buscaDatasDoVoo(voo);
		} catch (DaoVooException e) {
			new DaoVooException("Erro: não conseguiu buscar lista de aeroportos", e);
		}
		return lista;
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
}
