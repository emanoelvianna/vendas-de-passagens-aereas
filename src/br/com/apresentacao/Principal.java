package br.com.apresentacao;

import br.com.persistencia.Conexao;

public class Principal {

	public static void main(String[] args) throws Exception {

		System.out.println("-- Criando a base de dados --");
		Conexao.criarBd();

		System.out.println("-- Base de dados criada --");
	}
}
