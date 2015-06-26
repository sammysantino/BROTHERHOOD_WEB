package br.com.brotherhood.dao;

import org.hibernate.Session;
import br.com.brotherhood.entidade.Preferencia;
import br.com.brotherhood.hibernate.HibernateUtil;

public class OpcaoDao extends BaseDao {

	public void deletarPorPreferencia(Preferencia preferencia) throws DaoException {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.createQuery("DELETE FROM Opcao WHERE preferencia =:_preferencia").setParameter("_preferencia", preferencia).executeUpdate();
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

}
