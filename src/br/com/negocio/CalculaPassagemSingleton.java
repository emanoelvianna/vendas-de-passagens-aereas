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
			return new CalculoEstudante();
		case Funcionario:
			return new CalculoFuncionario();
		case Normal:
			return new CalculoNormal();
		}
		return null;
	}
}
