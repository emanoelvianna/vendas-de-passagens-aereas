package br.com.apresentacao;

import java.util.List;

import br.com.entidades.Aeroporto;
import br.com.persistencia.AeroportoDaoDerby;
import br.com.persistencia.Conexao;
import br.com.persistencia.PersistirDados;

public class Principal {

	public static void main(String[] args) throws Exception {

		System.out.println("-- Criando a base de dados --");
		Conexao.criarBd();
		PersistirDados dados = new PersistirDados();
		dados.lerTodosOsArquivos();

		System.out.println("-- Base de dados criada --");

		System.out.println("-- Imprimindo usuarios --");

		AeroportoDaoDerby aeroportos = new AeroportoDaoDerby();

		List<Aeroporto> lista = aeroportos.buscarTodos();
		for (Aeroporto u : lista) {
			System.out.println(u.getNome());
		}
	}
}
