package br.com.modelo.entidades;

import java.util.Date;

import br.com.modelo.enums.Documento;
import br.com.modelo.enums.Status;

public class Passagem {
	private String codigo;
	private String nomePassageiro;
	private Status status;
	private Date datahora;
	private int numeroAssento;
	private int numeroLocalizador;
	private Documento documento;
	private int checkin;
	private String codigoUsuario;
	private String companhiaAerea;

	public Passagem(String codigo, String nomePassageiro, Status status, Date datahora, int numeroAssento,
			int numeroLocalizador, Documento documento, int checkin, String codigoUsuario, String companhiaAerea) {
		this.codigo = codigo;
		this.nomePassageiro = nomePassageiro;
		this.status = status;
		this.datahora = datahora;
		this.numeroAssento = numeroAssento;
		this.numeroLocalizador = numeroLocalizador;
		this.documento = documento;
		this.checkin = checkin;
		this.codigoUsuario = codigoUsuario;
		this.companhiaAerea = companhiaAerea;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	public int getNumeroAssento() {
		return numeroAssento;
	}

	public void setNumeroAssento(int numeroAssento) {
		this.numeroAssento = numeroAssento;
	}

	public int getNumeroLocalizador() {
		return numeroLocalizador;
	}

	public void setNumeroLocalizador(int numeroLocalizador) {
		this.numeroLocalizador = numeroLocalizador;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public int getCheckin() {
		return checkin;
	}

	public void setCheckin(int checkin) {
		this.checkin = checkin;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setLogin(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getCompanhiaAerea() {
		return companhiaAerea;
	}

	public void setCompanhiaAerea(String companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}

}
