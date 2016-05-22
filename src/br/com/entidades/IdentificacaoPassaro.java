package br.com.entidades;

import br.com.enums.Documento;

public class IdentificacaoPassaro {

	private String nome;
	private Documento documento;
	private String numeroDocumento;
	private Integer numeroLocalizador;

	public IdentificacaoPassaro(String nome, Documento documento, String numeroDocumento) {
		this.nome = nome;
		this.documento = documento;
		this.numeroDocumento = numeroDocumento;
	}

	public String getNome() {
		return this.nome;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public Integer getNumeroLocalizador() {
		return numeroLocalizador;
	}
}
