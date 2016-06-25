package br.com.negocio.excecoes;

public class DaoAeroportoException extends Exception {
	public DaoAeroportoException() {
		super();
	}

	public DaoAeroportoException(String mensagem) {
		super(mensagem);
	}

	public DaoAeroportoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
