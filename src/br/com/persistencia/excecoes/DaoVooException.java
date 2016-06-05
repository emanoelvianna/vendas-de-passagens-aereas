package br.com.persistencia.excecoes;

public class DaoVooException extends Exception{
	public DaoVooException() {
		super();
	}

	public DaoVooException(String mensagem) {
		super(mensagem);
	}

	public DaoVooException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
