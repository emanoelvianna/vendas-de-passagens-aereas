package br.com.apresentacao;

import java.sql.SQLException;

import br.com.persistencia.PersistirDados;
import br.com.persistencia.conexao.Conexao;

public class Principal {
	
	public static void main(String[] args) {
		System.out.println("-- Criando a base de dados --");
		try {
			Conexao.criarBd();
			PersistirDados dados = new PersistirDados();
			dados.lerTodosOsArquivos();
			System.out.println("-- Base de dados criada --");
		} catch (SQLException exception) {
			System.out.println("Erro ao tentar criar a base de dados! " + exception);
		} catch (Exception exception) {
			System.out.println("Erro ao tentar criar a base de dados! " + exception);
		}
	}

}
