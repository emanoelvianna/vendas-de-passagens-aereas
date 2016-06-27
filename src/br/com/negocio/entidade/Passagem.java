package br.com.negocio.entidade;

import java.util.Date;

import org.joda.time.DateTime;

import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.Status;

public class Passagem {
	private String nomePassageiro;
	private Status status;
	private Date datahora;
	private int numeroAssento;
	private int numeroLocalizador;
	private Documento documento;
	private int checkin;
	private String codigoUsuario;
	private double valor;

	public Passagem(String nomePassageiro, Status status, Date datahora, int numeroAssento,
			int numeroLocalizador, Documento documento, int checkin, String codigoUsuario, double valor) {
		this.nomePassageiro = nomePassageiro;
		this.status = status;
		this.datahora = datahora;
		this.numeroAssento = numeroAssento;
		this.numeroLocalizador = numeroLocalizador;
		this.documento = documento;
		this.checkin = checkin;
		this.codigoUsuario = codigoUsuario;
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
