package br.com.persistencia.excecoes;

public class DaoDestinoException extends Exception{
	public DaoDestinoException() {
		super();
	}

	public DaoDestinoException(String mensagem) {
		super(mensagem);
	}

	public DaoDestinoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
