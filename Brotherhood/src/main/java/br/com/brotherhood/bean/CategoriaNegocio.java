package br.com.brotherhood.bean;

import org.hibernate.Session;
import br.com.brotherhood.entidade.Categoria;
import br.com.brotherhood.entidade.ValidacaoException;
import br.com.brotherhood.hibernate.HibernateUtil;
import br.com.brotherhood.negocio.NegocioException;

public class CategoriaNegocio {
	
	public void salvar(Categoria categoria) throws NegocioException {
		try {
			categoria.validar();
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(categoria);
	        session.getTransaction().commit();
		} catch (ValidacaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
