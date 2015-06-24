package br.com.brotherhood.dao;

import org.hibernate.Session;

import br.com.brotherhood.hibernate.HibernateUtil;

public class BaseDao {
	
	public <T> void salvar(T t) throws DaoException  {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(t);
	        session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
}
