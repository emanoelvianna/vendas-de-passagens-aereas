package br.com.persistencia;

public class DaoUsuarioException extends Exception {
	public DaoUsuarioException() {
		super();
	}

	public DaoUsuarioException(String mensagem) {
		super(mensagem);
	}

	public DaoUsuarioException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
