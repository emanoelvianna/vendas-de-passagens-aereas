package br.com.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.modelo.entidades.Aeroporto;
import br.com.modelo.entidades.Voo;
import br.com.persistencia.conexao.Conexao;
import br.com.persistencia.dao.AeroportoDao;
import br.com.persistencia.dao.VooDao;
import br.com.persistencia.excecoes.DaoUsuarioException;
import br.com.persistencia.excecoes.DaoVooException;

public class VooDaoDerby implements VooDao {

	private AeroportoDao aeroportoDao;

	@Override
	public void inserir(Voo voo) throws DaoVooException {
		String sql = "INSERT INTO VOO(CODIGO, NUMERODEASSENTOS, EQUIPAMENTO, COD_ORIGEM, COD_DESTINO) VALUES(?,?,?,?,?)";
		int resultado = 0;
		try {
			// recupera origem
			String codOrigem = voo.getOrigem().getCodigo();
			Aeroporto origem = aeroportoDao.buscarPorCodigo(codOrigem);

			// recupera destino
			String codDestino = voo.getDestino().getCodigo();
			Aeroporto destino = aeroportoDao.buscarPorCodigo(codOrigem);

			try (Connection conexao = Conexao.getConexao()) {
				try (PreparedStatement comando = conexao.prepareStatement(sql)) {
					comando.setString(1, voo.getCodigo());
					comando.setString(2, voo.getOrigem().getCodigo());
					comando.setString(3, voo.getDestino().getCodigo());
					comando.setString(4, voo.getCodeshare());
					comando.setInt(5, voo.getParadas());
					comando.setString(6, voo.getEquipamento());
					comando.setInt(7, voo.getNumeroDeAssentos());
					resultado = comando.executeUpdate();
				}
			}

		} catch (Exception e) {
			throw new DaoVooException("ERRO: falha vôo não inserido");
		}
		if (resultado == 0) {
			throw new DaoVooException("ERRO: falha vôo não inserido");
		}
	}

	@Override
	public Voo buscarPorCodigo(Integer codigo) throws DaoVooException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voo> buscarTodos() throws DaoVooException {
		// TODO Auto-generated method stub
		return null;
	}

}
