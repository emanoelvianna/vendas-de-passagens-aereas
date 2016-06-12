package br.com.apresentacao;

import java.util.Date;

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

		Passagem p = new Passagem("", "Teste", Status.PENDENTE, new Date(), 10, 1, Documento.CPF, 0, "1", "ACME");
		PassagemDaoDerby passagemDaoDerby = new PassagemDaoDerby();
		passagemDaoDerby.inserir(p);

		System.out.println("-- Base de dados criada --");

	}
}
