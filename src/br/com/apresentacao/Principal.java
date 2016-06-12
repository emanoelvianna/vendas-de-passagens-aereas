package br.com.apresentacao;

import br.com.persistencia.PersistirDados;
import br.com.persistencia.conexao.Conexao;

public class Principal {

	public static void main(String[] args) throws Exception {

		System.out.println("-- Criando a base de dados --");
		Conexao.criarBd();
		PersistirDados dados = new PersistirDados();
		dados.lerTodosOsArquivos();

		System.out.println("-- Base de dados criada --");

	}
}
