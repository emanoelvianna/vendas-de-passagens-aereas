package br.com.apresentacao;

import br.com.modelo.entidades.Usuario;
import br.com.persistencia.PersistirDados;
import br.com.persistencia.UsuarioDaoDerby;
import br.com.persistencia.conexao.Conexao;

public class Principal {

	public static void main(String[] args) throws Exception {

		System.out.println("-- Criando a base de dados --");
		Conexao.criarBd();
		PersistirDados dados = new PersistirDados();
		dados.lerTodosOsArquivos();

		UsuarioDaoDerby usuarioDaoDerby = new UsuarioDaoDerby();
		
		Usuario usuario = usuarioDaoDerby.buscarPorCodigo(1);
		
		System.out.println("-- Base de dados criada --");
		System.out.println(usuario.getLogin());

	}
}
