package br.com.negocio;

import java.sql.SQLException;
import java.sql.Timestamp;

import br.com.negocio.entidade.Usuario;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.TipoPassagem;
import br.com.persistencia.PersistirDados;
import br.com.persistencia.conexao.Conexao;

public class NegocioFachada {
	private AquisicaoDePassagem aquisicaoDePassagem;
	private LoginUsuario loginUsuario;
	private Usuario usuarioContexto;

	public NegocioFachada() {
		aquisicaoDePassagem = new AquisicaoDePassagem();
		loginUsuario = new LoginUsuario();
	}

	public void comprarPassagem(String nome, String documento, String data, String origem, String destino, String tipoPassagem) {
		Documento doc = Documento.valueOf(documento);
		TipoPassagem t = TipoPassagem.valueOf(tipoPassagem);
		Timestamp dat = Timestamp.valueOf(data);

		aquisicaoDePassagem.comprarPassagem(nome, doc, dat, origem, destino, usuarioContexto.getCodigo(), t);
	}

	public boolean loginUsuario(String login, String senha) {
		usuarioContexto = loginUsuario.validaLogin(login, senha);
		if(usuarioContexto != null)
			return true;
		return false;
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
