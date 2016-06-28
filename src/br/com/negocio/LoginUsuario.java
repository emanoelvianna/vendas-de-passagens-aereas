package br.com.negocio;

import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.entidade.Usuario;
import br.com.persistencia.UsuarioDaoDerby;

public class LoginUsuario {
	private UsuarioDao usuarioDao;

	public LoginUsuario() {
		usuarioDao = new UsuarioDaoDerby();
	}

	public Usuario validaLogin(String login, String senha) {
		Usuario usuario = usuarioDao.validaUsuario(login, senha);
		return usuario;
	}

}
