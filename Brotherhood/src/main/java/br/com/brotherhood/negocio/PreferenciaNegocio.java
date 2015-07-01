package br.com.brotherhood.negocio;

import java.util.List;
import br.com.brotherhood.dao.DaoException;
import br.com.brotherhood.dao.PreferenciaDao;
import br.com.brotherhood.entidade.ESituacao;
import br.com.brotherhood.entidade.Preferencia;
import br.com.brotherhood.entidade.ValidacaoException;

public class PreferenciaNegocio extends BaseNegocio<Preferencia> {
	
	private final PreferenciaDao preferenciaDao = new PreferenciaDao();

	public void salvar(Preferencia preferencia) throws NegocioException, ValidacaoException {
		try {
			preferencia.validar();
			if (preferencia.getId() == null) {
				preferenciaDao.salvar(preferencia);
			} else {
				OpcaoNegocio opcaoNegocio = new OpcaoNegocio();
				opcaoNegocio.deletarPorPreferencia(preferencia);
				preferenciaDao.alterar(preferencia);
			}
		} catch (DaoException e) {
			throw new NegocioException(e.getMessage());
		} 
	}

	public List<Preferencia> obterTodosPorSituacao(ESituacao ativo) throws NegocioException {
		try {
			return preferenciaDao.consultarTodasPorSituacao(ativo);
		} catch (DaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
