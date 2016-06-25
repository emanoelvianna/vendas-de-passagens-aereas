package br.com.persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.joda.time.DateTime;

import br.com.negocio.CompanhiaAerea;
import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.dao.CompanhiaAereaDao;
import br.com.negocio.dao.UsuarioDao;
import br.com.negocio.dao.VooDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Usuario;
import br.com.negocio.entidade.Voo;

//TODO: A data passada para o construtor do voo deve ser gerada randomicamente 

public class PersistirDados {

	BufferedReader br = null;
	private String linha;
	private String divisor = ";";

	public void lerTodosOsArquivos() {
		lerArquivoDeCompanhiasAereas();
		lerArquivoDeAeroportos();
		lerArquivoDeUsuarios();
		lerArquivoDeVoos();
	}

	public void lerArquivoDeCompanhiasAereas() {
		CompanhiaAereaDao companhiaAereaDaoDerby = new CompanhiaAereaDaoDerby();
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
		UsuarioDao UsuarioDao = new UsuarioDaoDerby();
		try {
			br = new BufferedReader(new FileReader("dados/usuario.csv"));
			// ignorando a primeira linha do arquivo
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(divisor);
				Usuario usuario = new Usuario(info[0], info[1], info[2]);
				UsuarioDao.inserir(usuario);
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

	public void lerArquivoDeVoos() {
		VooDao vooDaoDerby = new VooDaoDerby();
		AeroportoDao aeroportoDao = new AeroportoDaoDerby();
		CompanhiaAereaDao companhiaAereaDao = new CompanhiaAereaDaoDerby();
		try {
			br = new BufferedReader(new FileReader("dados/rotas.csv"));
			// ignorando a primeira linha do arquivo
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(divisor);
				CompanhiaAerea companhiaAerea = companhiaAereaDao.buscarPorCodigo(info[1]);
				Aeroporto origem = aeroportoDao.buscarPorCodigo(info[2]);
				Aeroporto destino = aeroportoDao.buscarPorCodigo(info[3]);
				Voo voo = new Voo(info[0], companhiaAerea, origem, destino, info[4], Integer.parseInt(info[5]), info[6],
						50, new DateTime());
				vooDaoDerby.inserir(voo);
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

	public void lerArquivoDeAeroportos() {
		AeroportoDaoDerby aeroportoDaoDerby = new AeroportoDaoDerby();
		try {
			br = new BufferedReader(new FileReader("dados/airports.dat"));
			// ignorando a primeira linha do arquivo
			br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] info = linha.split(divisor);
				Aeroporto aeroporto = new Aeroporto(info[0], info[1], info[2], info[3]);
				aeroportoDaoDerby.inserir(aeroporto);
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
