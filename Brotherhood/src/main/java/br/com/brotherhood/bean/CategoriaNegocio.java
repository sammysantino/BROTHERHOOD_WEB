package br.com.brotherhood.bean;

import org.hibernate.Session;

import br.com.brotherhood.entidade.Categoria;
import br.com.brotherhood.entidade.ESituacao;
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
	        session.close();
		} catch (ValidacaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void ativar(Categoria categoria) throws NegocioException {
		try {
			categoria.validar();
			categoria.setSituacao(ESituacao.ATIVO);
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.update(categoria);
	        session.getTransaction().commit();
	        session.close();
		} catch (ValidacaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void inativar(Categoria categoria) throws NegocioException {
		try {
			categoria.validar();
			categoria.setSituacao(ESituacao.INATIVO);
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.update(categoria);
	        session.getTransaction().commit();
	        session.close();
		} catch (ValidacaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void alterar(Categoria categoria) throws NegocioException {
		try {
			categoria.validar();
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.update(categoria);
	        session.getTransaction().commit();
	        session.close();
		} catch (ValidacaoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
