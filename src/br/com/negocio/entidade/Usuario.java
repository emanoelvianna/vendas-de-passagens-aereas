package br.com.negocio.entidade;

public class Usuario {

	private String codigo;
	private String login;
	private String senha;

	public Usuario(String codigo, String login, String senha) {
		this.setCodigo(codigo);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
