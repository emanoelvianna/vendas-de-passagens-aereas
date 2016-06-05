package br.com.persistencia;

import java.util.List;

import br.com.modelo.entidades.Aeroporto;
import br.com.modelo.entidades.Origem;
import br.com.modelo.entidades.Voo;
import br.com.persistencia.dao.AeroportoDao;
import br.com.persistencia.dao.VooDao;
import br.com.persistencia.excecoes.DaoVooException;

public class VooDaoDerby implements VooDao {

	private AeroportoDao aeroportoDao;

	@Override
	public void inserir(Voo voo) throws DaoVooException {
		String sql = "INSERT INTO VOO(CODIGO, NUMERODEASSENTOS, EQUIPAMENTO, COD_ORIGEM, COD_DESTINO)";
		int resultado = 0;
		try {
			// recupera origem
			String codOrigem = voo.getOrigem().getCodigo();
			Aeroporto origem = aeroportoDao.buscarPorCodigo(codOrigem);

			// recupera destino
			String codDestino = voo.getDestino().getCodigo();
			Aeroporto destino = aeroportoDao.buscarPorCodigo(codOrigem);
			
			// TODO: resto do código

		} catch (Exception e) {
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
