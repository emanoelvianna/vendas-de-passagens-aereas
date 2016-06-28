package br.com.negocio.entidade;

import java.sql.Timestamp;
import java.util.List;

import br.com.negocio.enumeracao.Documento;
import br.com.negocio.enumeracao.Status;

public class Passagem {
	private Usuario usuario;
	private CompanhiaAerea companhiaAerea;
	private String nome;
	private Status status;
	private int checkin;
	private Timestamp dataHora;
	private int numeroAssento;
	private Documento documento;
	private int localizador;
	private double valor;
	private List<Voo> voos;

	public Passagem(Usuario usuario, CompanhiaAerea companhiaAerea, String nome, Status status, int checkin, Timestamp dataHora, int numeroAssento,
			Documento documento, int localizador, double valor, List<Voo> voos) {
		this.usuario = usuario;
		this.companhiaAerea = companhiaAerea;
		this.nome = nome;
		this.status = status;
		this.checkin = checkin;
		this.dataHora = dataHora;
		this.numeroAssento = numeroAssento;
		this.documento = documento;
		this.localizador = localizador;
		this.valor = valor;
		this.voos = voos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}

	public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getCheckin() {
		return checkin;
	}

	public void setCheckin(int checkin) {
		this.checkin = checkin;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public int getNumeroAssento() {
		return numeroAssento;
	}

	public void setNumeroAssento(int assento) {
		this.numeroAssento = assento;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public int getLocalizador() {
		return localizador;
	}

	public void setLocalizador(int localizador) {
		this.localizador = localizador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Voo> getVoos() {
		return voos;
	}

	public void setVoos(List<Voo> voos) {
		this.voos = voos;
	}
	
	 public boolean addVoo(Voo voo){
	        for(Voo v : voos) {
	            if(v.getCodigo() == voo.getCodigo()) {
	                return true;
	            }
	        }
	        return voos.add(voo);
	    }

}
