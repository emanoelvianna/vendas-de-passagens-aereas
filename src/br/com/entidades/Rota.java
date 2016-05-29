package br.com.entidades;

public class Rota {

	private String codigo;
	private CompanhiaAerea companhiaAerea;
	private Aeroporto origem;
	private Aeroporto destino;
	private String codeShare;
	private int paradas;
	private String equipamentos;

	public Rota(String codigo, String codeShare, int paradas, String equipamentos) {
		this.codigo = codigo;
		this.companhiaAerea = companhiaAerea;
		this.origem = origem;
		this.destino = destino;
		this.codeShare = codeShare;
		this.paradas = paradas;
		this.equipamentos = equipamentos;
	}

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
		return codeShare;
	}

	public void setCodeShare(String codeShare) {
		codeShare = codeShare;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
