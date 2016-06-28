package br.com.negocio;

import java.sql.Timestamp;

import br.com.negocio.entidade.Usuario;
import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.TipoPassagem;

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

	public void loginUsuario(String login, String senha) {
		usuarioContexto = loginUsuario.validaLogin(login, senha);
		System.out.println(usuarioContexto.getLogin());
	}
}
