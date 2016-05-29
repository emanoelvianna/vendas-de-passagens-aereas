package br.com.apresentacao;

import java.util.List;

import br.com.entidades.Usuario;
import br.com.persistencia.Conexao;
import br.com.persistencia.PersistirDados;
import br.com.persistencia.UsuarioDaoDerby;

public class Principal {

	public static void main(String[] args) throws Exception {

		System.out.println("-- Criando a base de dados --");
		Conexao.criarBd();
		PersistirDados dados = new PersistirDados();
		dados.lerTodosOsArquivos();

		System.out.println("-- Base de dados criada --");

		System.out.println("-- Imprimindo usuarios --");
		UsuarioDaoDerby usuario = new UsuarioDaoDerby();
		List<Usuario> lista = usuario.buscarTodos();
		for (Usuario u : lista) {
			System.out.println(u.getLogin());
		}
	}
}
