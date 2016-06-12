package br.com.apresentacao;

import org.joda.time.DateTime;

import br.com.modelo.entidades.Passagem;
import br.com.modelo.enums.Documento;
import br.com.modelo.enums.Status;
import br.com.persistencia.PassagemDaoDerby;
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
