package br.com.brotherhood.dao;

import java.util.List;
import org.hibernate.Session;
import br.com.brotherhood.entidade.Categoria;
import br.com.brotherhood.entidade.ESituacao;
import br.com.brotherhood.hibernate.HibernateUtil;

public class CategoriaDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Categoria> consultarTodasPorSituacao(ESituacao situacao) throws DaoException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT c ");
			sql.append("FROM Categoria c ");
			sql.append("WHERE c.situacao =:_situacao ");
			sql.append("ORDER BY c.titulo ");
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Categoria> categorias = session.createQuery(sql.toString())
					.setParameter("_situacao", situacao)
					.list();
			session.close();
			
			return categorias;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
}
