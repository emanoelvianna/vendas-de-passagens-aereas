package br.com.persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.entidades.CompanhiaAerea;
import br.com.entidades.Usuario;

public class PersistirDados {

	BufferedReader br = null;
	private String linha;
	private String divisor = ";";
	
	public void lerTodosOsArquivos() {
		//lerArquivoDeCompanhiasAereas();
		lerArquivoDeUsuarios();
	}

	public void lerArquivoDeCompanhiasAereas() {
		CompanhiaAereaDaoDerby companhiaAereaDaoDerby = new CompanhiaAereaDaoDerby();
		try {
			br = new BufferedReader(new FileReader("dados/airlines.dat"));
			// ignorando a primeira linha do arquivo
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(divisor);
				CompanhiaAerea companhiaAerea = new CompanhiaAerea(info[0], info[1]);
				companhiaAereaDaoDerby.inserir(companhiaAerea);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void lerArquivoDeUsuarios() {
		UsuarioDaoDerby usuarioDAOderby = new UsuarioDaoDerby();
		try {
			br = new BufferedReader(new FileReader("dados/usuario.csv"));
			// ignorando a primeira linha do arquivo
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(divisor);
				Usuario usuario = new Usuario(info[0], info[1], info[2]);
				usuarioDAOderby.inserir(usuario);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
