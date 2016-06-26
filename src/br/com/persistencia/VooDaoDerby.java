package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.negocio.CompanhiaAerea;
import br.com.negocio.dao.AeroportoDao;
import br.com.negocio.dao.VooDao;
import br.com.negocio.entidade.Aeroporto;
import br.com.negocio.entidade.Voo;
import br.com.negocio.excecoes.DaoVooException;
import br.com.persistencia.conexao.Conexao;

public class VooDaoDerby implements VooDao {

	private AeroportoDao aeroportoDao = new AeroportoDaoDerby();

	@Override
	public void inserir(Voo voo) throws DaoVooException {
		String sql = "INSERT INTO VOO(CODIGO, COMPANHIA, CODIGOORIGEM, CODIGODESTINO, CODESHARE, PARADAS, EQUIPAMENTO, ASSENTOS, DATAHORA) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int resultado = 0;
		try {
			// recupera origem
			String codOrigem = voo.getOrigem().getCodigo();
			Aeroporto origem = aeroportoDao.buscarPorCodigo(codOrigem);

			// recupera destino
			String codDestino = voo.getDestino().getCodigo();
			Aeroporto destino = aeroportoDao.buscarPorCodigo(codDestino);

			try (Connection conexao = Conexao.getConexao()) {
				try (PreparedStatement comando = conexao.prepareStatement(sql)) {
					comando.setString(1, voo.getCodigo());
					comando.setString(2, voo.getCompanhiaAerea().getCodigo());
					comando.setString(3, origem.getCodigo());
					comando.setString(4, destino.getCodigo());
					comando.setString(5, voo.getCodeshare());
					comando.setInt(6, voo.getParadas());
					comando.setString(7, voo.getEquipamento());
					comando.setInt(8, voo.getNumeroDeAssentos());
					comando.setString(9, voo.getData().toString());
					resultado = comando.executeUpdate();
				}
			}

		} catch (Exception e) {
			throw new DaoVooException("ERRO: falha voo nao inserido");
		}
		if (resultado == 0) {
			throw new DaoVooException("ERRO: falha voo nao inserido");
		}
	}

	@Override
	public Voo buscarPorCodigo(Integer codigo) throws DaoVooException {

		return null;
	}

	@Override
	public List<Voo> buscarTodos() throws DaoVooException {
		CompanhiaAerea companhiaAerea = null;
		Aeroporto aeroportoOrigem = null;
		Aeroporto aeroportoDestino = null;
		
		String sql = "SELECT * FROM VOO";
		String sqlCompanhiaAerea = "SELECT * FROM COMPANHIA WHERE CODIGO = ?";
		String sqlAeroporto = "SELECT * FROM AEROPORTO WHERE CODIGO = ?";

		
		
		return null;
	}

	public List<Voo> buscarListaOrigem() throws DaoVooException {
		CompanhiaAerea companhiaAerea = null;
		String sql = "SELECT * FROM VOO";
		String sqlCompanhiaAerea = "SELECT * FROM COMPANHIA WHERE CODIGO = ?";
		String sqlAeroportoOrigem = "SELECT * FROM AEROPORTO WHERE CODIGO = ?";

		try (Connection conexao = Conexao.getConexao()) {

		} catch (Exception e) {
			new Exception("Erro ao buscar todos os voos");
		}
		return null;
	}

	@Override
	public List<Voo> buscarListaDestino(Voo origem) throws DaoVooException {
		return null;
	}

}
