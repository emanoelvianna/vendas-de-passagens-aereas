package br.com.persistencia.excecoes;

public class DaoOrigemException extends Exception{
	public DaoOrigemException() {
		super();
	}

	public DaoOrigemException(String mensagem) {
		super(mensagem);
	}

	public DaoOrigemException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
