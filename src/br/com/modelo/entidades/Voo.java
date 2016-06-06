package br.com.modelo.entidades;

public class Voo {
	private String codigo;
	private CompanhiaAerea companhiaAerea;
	private Aeroporto origem;
	private Aeroporto destino;
	private String codeshare;
	private int paradas;
	private String equipamento;
	private int numeroDeAssentos;

	public Voo(String codigo, CompanhiaAerea companhiaAerea, Aeroporto origem, Aeroporto destino, String codeshare,
			int paradas, String equipamento, int numeroDeAssentos) {
		this.codigo = codigo;
		this.companhiaAerea = companhiaAerea;
		this.origem = origem;
		this.destino = destino;
		this.codeshare = codeshare;
		this.paradas = paradas;
		this.equipamento = equipamento;
		this.numeroDeAssentos = numeroDeAssentos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNumeroDeAssentos() {
		return numeroDeAssentos;
	}

	public void setNumeroDeAssentos(int numeroDeAssentos) {
		this.numeroDeAssentos = numeroDeAssentos;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public Aeroporto getOrigem() {
		return origem;
	}

	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}

	public String getCodeshare() {
		return codeshare;
	}

	public void setCodeshare(String codeshare) {
		this.codeshare = codeshare;
	}

	public int getParadas() {
		return paradas;
	}

	public void setParadas(int paradas) {
		this.paradas = paradas;
	}

	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}

	public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}

}
