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
		case Estudante:
			// 15% de desconto para estudantes 
			return new CalculoEstudante();
		case Funcionario:
			// 10% de desconto para estudantes 
			return new CalculoFuncionario();
		case Normal:
			// retorna o valor normal da passagem, sem desconto
			return new CalculoNormal();
		}
		return null;
	}
}
