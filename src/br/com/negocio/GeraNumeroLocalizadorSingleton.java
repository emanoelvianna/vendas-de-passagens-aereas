package br.com.negocio;

public class GeraNumeroLocalizadorSingleton {
	private static GeraNumeroLocalizadorSingleton instancia = null;
	private int numeroLocalizador = 1;

	private GeraNumeroLocalizadorSingleton() {
		// ** garante uma instancia unica.
	}

	public static GeraNumeroLocalizadorSingleton getGeraNumeroLocalizadorSingleton() {
		if (instancia == null) {
			return instancia = new GeraNumeroLocalizadorSingleton();
		} else {
			return instancia;
		}
	}

	public int gerarNumeroLocalizador() {
		return numeroLocalizador++;
	}
}
