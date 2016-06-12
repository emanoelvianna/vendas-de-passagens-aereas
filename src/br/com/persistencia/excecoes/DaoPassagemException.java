package br.com.persistencia.excecoes;

public class DaoPassagemException extends Exception {
	public DaoPassagemException() {
		super();
	}

	public DaoPassagemException(String mensagem) {
		super(mensagem);
	}

	public DaoPassagemException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
