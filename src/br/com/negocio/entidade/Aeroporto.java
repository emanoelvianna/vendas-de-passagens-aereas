package br.com.negocio.entidade;

public class Aeroporto {
	private String codigo;
	private String nome;
	private String longitude;
	private String latitude;

	public Aeroporto(String codigo, String nome, String longitude, String latitude) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.longitude = longitude;
		this.latitude = latitude;
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
