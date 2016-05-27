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

public class Dados {

	BufferedReader br = null;
	private String linha;
	private String divisor = ";";

	public void lerArquivoDeCompanhiasAereas() {

		try {
			br = new BufferedReader(new FileReader("dados/airlines.dat"));
			// ignorando a primeira linha do arquivo
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(divisor);
				CompanhiaAerea companhiaAerea = new CompanhiaAerea(info[0], info[1]);
				inserir(companhiaAerea);
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

	public List<CompanhiaAerea> buscarTodos() throws Exception {
		List<CompanhiaAerea> lista = new ArrayList<>();
		String sql = "SELECT * FROM COMPANHIAS";

		try (Connection conexao = Conexao.getConexao()) {
			try (Statement comando = conexao.createStatement()) {
				try (ResultSet resultado = comando.executeQuery(sql)) {
					while (resultado.next()) {
						CompanhiaAerea companhiaAerea = new CompanhiaAerea(
								resultado.getString(1),
								resultado.getString(2));
						lista.add(companhiaAerea);
					}
					return lista;
				}
			}
		} catch (Exception e) {
			throw new Exception("Falha na busca", e);
		}
	}

	public void inserir(CompanhiaAerea companhiaAerea) throws Exception {
		String sql = "INSERT INTO COMPANHIAS(codigo,nome) VALUES(?,?)";
		int resultado = 0;
		try (Connection conexao = Conexao.getConexao()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, companhiaAerea.getCodigo());
				comando.setString(2, companhiaAerea.getNome());
				resultado = comando.executeUpdate();
			}
		} catch (Exception e) {
			throw new Exception("Erro1", e);
		}
		if (resultado == 0) {
			throw new Exception("Erro2");
		}
	}
}
