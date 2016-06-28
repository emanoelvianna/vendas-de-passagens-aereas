package br.com.negocio;

import br.com.negocio.enumeracao.TipoPassagem;

public class CalculaPassagemSingleton {
	private static CalculaPassagemSingleton instancia;

	private CalculaPassagemSingleton() {
	}

	public static CalculaPassagemSingleton getCalculoIrpfSingleton() {
		if (instancia == null)
			return new CalculaPassagemSingleton();
		else
			return instancia;
	}

	public CalculaPassagem createInstance(TipoPassagem tipoPassagem) {
		switch (tipoPassagem) {
		case ESTUDANTE:
			// 15% de desconto para estudantes 
			return new CalculoEstudante();
		case FUNCIONARIO:
			// 10% de desconto para estudantes 
			return new CalculoFuncionario();
		case NORMAL:
			// retorna o valor normal da passagem, sem desconto
			return new CalculoNormal();
		}
		return null;
	}
}
