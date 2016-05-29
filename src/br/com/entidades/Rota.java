package br.com.entidades;

public class Rota {

	private String codigo;
	private CompanhiaAerea companhiaAerea;
	private Aeroporto origem;
	private Aeroporto destino;
	private String CodeShare;
	private int paradas;
	private String equipamentos;

	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}

	public void setCompanhiaAerea(CompanhiaAerea companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
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

	public String getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}

	public int getParadas() {
		return paradas;
	}

	public void setParadas(int paradas) {
		this.paradas = paradas;
	}

	public String getCodeShare() {
		return CodeShare;
	}

	public void setCodeShare(String codeShare) {
		CodeShare = codeShare;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
