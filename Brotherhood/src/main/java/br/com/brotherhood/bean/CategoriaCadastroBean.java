package br.com.brotherhood.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import br.com.brotherhood.entidade.Categoria;
import br.com.brotherhood.hibernate.HibernateUtil;
import br.com.brotherhood.negocio.NegocioException;

@ViewScoped
@ManagedBean
public class CategoriaCadastroBean extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private CategoriaNegocio categoriaNegocio = new CategoriaNegocio();
	private Categoria categoria;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void inicializar() {
		construirCategoria();
		carregarCategorias();
	}
	
	public void construirCategoria() {
		categoria = new Categoria();
	}

	@SuppressWarnings("unchecked")
	private void carregarCategorias() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		categorias = (List<Categoria>) session.createQuery("FROM Categoria c ORDER BY c.descricao ").list();
	}
	
	public void salvar() {
		try {
			if (categoria.getId() == null) {
				categoriaNegocio.salvar(categoria);
				makeInfoMessage("Categoria cadastrada com sucesso!", "");
			} else {
				categoriaNegocio.alterar(categoria);
				makeInfoMessage("Categoria editada com sucesso!", "");
			}
		} catch (NegocioException e) {
			e.printStackTrace();
			makeWarnMessage(e.getMessage(), "ERRO");
		}
        construirCategoria();
        carregarCategorias();
	}
	
	public void editar(Categoria categoriaSelecionada) {
		this.categoria = categoriaSelecionada;
	}
	
	public void ativar(Categoria categoriaSelecionada) {
		try {
			categoriaNegocio.ativar(categoriaSelecionada);
			makeInfoMessage("Categoria ativada com sucesso!", "");
		} catch (NegocioException e) {
			e.printStackTrace();
			makeWarnMessage(e.getMessage(), "ERRO");
		}
	}
	
	public void inativar(Categoria categoriaSelecionada) {
		try {
			categoriaNegocio.inativar(categoriaSelecionada);
			makeInfoMessage("Categoria inativada com sucesso!", "");
		} catch (NegocioException e) {
			e.printStackTrace();
			makeWarnMessage(e.getMessage(), "ERRO");
		}
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}
