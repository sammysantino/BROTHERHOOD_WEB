package br.com.brotherhood.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.brotherhood.entidade.Categoria;
import br.com.brotherhood.negocio.NegocioException;

@ViewScoped
@ManagedBean
public class PreferenciaUsuarioBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	private CategoriaNegocio categoriaNegocio = new CategoriaNegocio();
	
	private List<Categoria> categorias;
	
	@PostConstruct
	public void inicializar() {
		carregarCategorias();
	}

	private void carregarCategorias() {
		try {
			categorias = categoriaNegocio.obterTodosAtivosCompletos();
		} catch (NegocioException e) {
			e.printStackTrace();
			makeErrorMessage("ERRO: " + e.getMessage(), "");
		}
	}
	
	public void salvar() {
		//TODO
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
