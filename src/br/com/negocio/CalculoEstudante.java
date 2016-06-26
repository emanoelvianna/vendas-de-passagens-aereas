package br.com.negocio;

public class CalculoEstudante implements CalculaPassagem {

	@Override
	public double descontoPromocao(double valorPassagem) {
		double desconto = 15;
		double calculo = desconto * valorPassagem;
		return calculo / 100;
	}

}
