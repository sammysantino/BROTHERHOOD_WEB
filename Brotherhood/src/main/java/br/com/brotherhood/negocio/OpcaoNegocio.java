package br.com.brotherhood.negocio;

import br.com.brotherhood.dao.DaoException;
import br.com.brotherhood.dao.OpcaoDao;
import br.com.brotherhood.entidade.Preferencia;

public class OpcaoNegocio {
	
	private OpcaoDao opcaoDao = new OpcaoDao();

	public void deletarPorPreferencia(Preferencia preferencia) throws NegocioException {
		try {
			opcaoDao.deletarPorPreferencia(preferencia);
		} catch (DaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

}
