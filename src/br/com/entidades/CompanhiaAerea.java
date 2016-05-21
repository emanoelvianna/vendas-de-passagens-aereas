package br.com.entidades;

public class CompanhiaAerea {

	private String codigo;
	private String nome;

	public CompanhiaAerea(String codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
