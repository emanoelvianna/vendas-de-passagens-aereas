package br.com.negocio;

import br.com.negocio.entidade.Usuario;

public class Principal {
	public static void main(String[] args) {
		NegocioFachada fachada = new NegocioFachada();

		// comportamento para a tela de login:
		String codigoUsuario = "1";
		String login = "lmontgomery0@dmoz.org";
		String senha = "iodl65DoE4ZI";

		fachada.loginUsuario(login, senha);
		
		
		// comportamento para a tela de compra de passagem:

		Usuario usuarioContexto = new Usuario(codigoUsuario, login, senha);
		
		
		String nome = "lmontgomery";
		String origem = "Sochi";
		String destino = "Kazan";
		String tipoPassagem = "ESTUDANTE";
		
		fachada.comprarPassagem(nome, "RG", "2016-06-28 04:09:07.015", origem, destino, tipoPassagem);
		 
	}
}
