package br.com.brotherhood.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.brotherhood.entidade.Preferencia;
import br.com.brotherhood.negocio.NegocioException;
import br.com.brotherhood.negocio.PreferenciaNegocio;

@ViewScoped
@ManagedBean
public class PreferenciaCadastroBean extends BaseBean {
	
	private PreferenciaNegocio preferenciaNegocio = new PreferenciaNegocio();
	private Preferencia preferencia;
	private List<Preferencia> preferencias;
	
	@PostConstruct
	public void inicializar() {
		construirPreferencia();
		carregarPreferencias();
	}
	
	public void construirPreferencia() {
		preferencia = new Preferencia();
	}

	private void carregarPreferencias() {
		
	}
	
	public void salvar() {
		try {
			preferenciaNegocio.salvar(preferencia);
			makeInfoMessage("Categoria cadastrada com sucesso!", "");
		} catch (NegocioException e) {
			e.printStackTrace();
			makeWarnMessage(e.getMessage(), "ERRO");
		}
		inicializar();
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}
}
