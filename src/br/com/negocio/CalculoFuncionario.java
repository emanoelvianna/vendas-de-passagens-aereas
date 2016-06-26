package br.com.negocio;

public class CalculoFuncionario implements CalculaPassagem {

	@Override
	public double descontoPromocao(double valorPassagem) {
		double desconto = 10;
		double calculo = desconto * valorPassagem;
		return calculo / 100;
	}

}
