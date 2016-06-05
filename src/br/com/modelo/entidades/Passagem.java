package br.com.modelo.entidades;

import java.util.Date;

import br.com.modelo.enums.Documento;
import br.com.modelo.enums.Status;

public class Passagem {
	private String codigo;
	private String nomePassageiro;
	private Status status;
	private Date data;
	private int numeroAssento;
	private int numeroLocalizador;
	private Documento documento;
	private boolean checkin;

}
