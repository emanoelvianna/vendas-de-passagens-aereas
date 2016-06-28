package br.com.apresentacao;

import br.com.negocio.NegocioFachada;

public class PrincipalControlador {

	NegocioFachada fachada = new NegocioFachada();

	public boolean login(String login, String senha) {
		boolean eValido = fachada.loginUsuario(login, senha);
		if(eValido == true)
			return true;
		return false;
	}
	
	public void criarBaseDeDados() {
		fachada.criarBaseDeDados();
	}
}
