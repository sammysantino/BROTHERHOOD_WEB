package br.com.brotherhood.dao;

import java.util.List;
import org.hibernate.Session;
import br.com.brotherhood.entidade.ESituacao;
import br.com.brotherhood.entidade.Preferencia;
import br.com.brotherhood.hibernate.HibernateUtil;

public class PreferenciaDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Preferencia> consultarTodasPorSituacao(ESituacao ativo) throws DaoException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT p ");
			sql.append("FROM Preferencia p ");
			sql.append("WHERE p.situacao =:_situacao ");
			sql.append("ORDER BY p.titulo ");
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Preferencia> preferencias = session.createQuery(sql.toString()).list();
			session.close();
			
			return  preferencias;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
}
