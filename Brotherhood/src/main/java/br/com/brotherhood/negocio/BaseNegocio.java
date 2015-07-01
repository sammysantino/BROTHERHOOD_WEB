package br.com.brotherhood.negocio;

import java.io.Serializable;
import br.com.brotherhood.dao.BaseDao;
import br.com.brotherhood.dao.DaoException;

public class BaseNegocio<T> {
	
	private T tipo;
	private BaseDao baseDao = new BaseDao();
	
	public T obterPorId(Serializable id) throws NegocioException {
		try {
			return (T) baseDao.consultarPorId(tipo.getClass(), id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new NegocioException(e.getMessage());
		}
	}
}
