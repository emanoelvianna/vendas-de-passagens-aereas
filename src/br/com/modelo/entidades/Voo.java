package br.com.modelo.entidades;

public class Voo {
	private String codigo;
	private int numeroDeAssentos;
	private String equipamento;
	private Aeroporto origem;
	private Aeroporto destino;

	public Voo(String codigo, int numeroDeAssentos, String equipamento, Aeroporto origem, Aeroporto destino) {
		this.setCodigo(codigo);
		this.setNumeroDeAssentos(numeroDeAssentos);
		this.setEquipamento(equipamento);
		this.origem = origem;
		this.destino = destino;
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

}
