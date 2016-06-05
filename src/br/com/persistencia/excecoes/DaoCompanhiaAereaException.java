package br.com.persistencia.excecoes;

public class DaoCompanhiaAereaException extends Exception {
	public DaoCompanhiaAereaException() {
		super();
	}

	public DaoCompanhiaAereaException(String mensagem) {
		super(mensagem);
	}

	public DaoCompanhiaAereaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
