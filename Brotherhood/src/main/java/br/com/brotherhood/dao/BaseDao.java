package br.com.brotherhood.dao;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.brotherhood.hibernate.HibernateUtil;

public class BaseDao {
	
	public <T> void salvar(T t) throws DaoException  {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(t);
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
	
	public <T> void alterar(T t) throws DaoException  {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.update(t);
	        session.getTransaction().commit();
	        session.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}

	public Object consultarPorId(Class clazz, Serializable id) throws DaoException {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        return session.get(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
}
