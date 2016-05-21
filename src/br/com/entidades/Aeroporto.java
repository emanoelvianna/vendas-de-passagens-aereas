package br.com.entidades;

public class Aeroporto {

	private String codigo;
	private String latitude;
	private String longitude;
	private String nome;

	public Aeroporto(String codigo, String latitude, String longitude, String nome) {
		this.codigo = codigo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
