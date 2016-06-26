package br.com.negocio;

public class GeraNumeroLocalizadorSingleton {
	private static GeraNumeroLocalizadorSingleton geraNumeroLocalizadorSingleton = null;
	private int numeroLocalizador = 1;

	private GeraNumeroLocalizadorSingleton() {
		// ** garante uma instancia unica.
	}

	public static GeraNumeroLocalizadorSingleton getGeraNumeroLocalizadorSingleton() {
		if (geraNumeroLocalizadorSingleton == null) {
			return geraNumeroLocalizadorSingleton = new GeraNumeroLocalizadorSingleton();
		} else {
			return geraNumeroLocalizadorSingleton;
		}
	}

	public int gerarNumeroLocalizador() {
		return numeroLocalizador++;
	}
}
