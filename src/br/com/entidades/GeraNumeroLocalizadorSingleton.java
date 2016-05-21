package br.com.entidades;

import java.util.Random;

public class GeraNumeroLocalizadorSingleton {
	private Random random;

	private GeraNumeroLocalizadorSingleton() {

	}

	//TODO: Problema: mais um passageiro ter o mesmo número.
	public Integer gerarNumeroLocalizador() {
		random = new Random();
		int numero = random.nextInt(10000);
		return numero;
	}
}
