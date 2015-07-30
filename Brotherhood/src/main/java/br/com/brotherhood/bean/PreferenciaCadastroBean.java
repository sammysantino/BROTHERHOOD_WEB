package br.com.brotherhood.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.brotherhood.entidade.Categoria;
import br.com.brotherhood.entidade.ESituacao;
import br.com.brotherhood.entidade.ETipoPreferencia;
import br.com.brotherhood.entidade.Opcao;
import br.com.brotherhood.entidade.Preferencia;
import br.com.brotherhood.entidade.ValidacaoException;
import br.com.brotherhood.negocio.NegocioException;
import br.com.brotherhood.negocio.PreferenciaNegocio;

@ViewScoped
@ManagedBean
public class PreferenciaCadastroBean extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private final PreferenciaNegocio preferenciaNegocio = new PreferenciaNegocio();
	private final CategoriaNegocio categoriaNegocio = new CategoriaNegocio();
	
	private Preferencia preferencia;
	private List<Preferencia> preferencias;
	private Integer idCategoria;
	private List<Categoria> categorias;
	private ETipoPreferencia[] tiposPreferencias;
	private ETipoPreferencia tipoPreferencia;
	private Opcao opcao;
	private List<Opcao> opcoes;
	
	@PostConstruct
	public void inicializar() {
		construirPreferencia();
		carregarPreferencias();
		carregarCategorias();
		carregarTiposPreferencias();
		carregarOpcoes();
	}
	
	private void carregarOpcoes() {
		opcao = new Opcao();
		opcoes = new ArrayList<Opcao>();
	}

	private void carregarTiposPreferencias() {
		tiposPreferencias = ETipoPreferencia.values();
	}

	private void carregarCategorias() {
		try {
			categorias = categoriaNegocio.obterTodosPorSituacao(ESituacao.ATIVO);
		} catch (NegocioException e) {
			e.printStackTrace();
		}
	}

	public void construirPreferencia() {
		preferencia = new Preferencia();
	}

	private void carregarPreferencias() {
		try {
			preferencias = preferenciaNegocio.obterTodosPorSituacao(ESituacao.ATIVO);
		} catch (NegocioException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			preferencia.setCategoria(new Categoria(idCategoria));
			preferencia.setOpcoes(opcoes);
			preferenciaNegocio.salvar(preferencia);
			construirPreferencia();
			carregarPreferencias();
			makeInfoMessage("Preferência cadastrada com sucesso!", "");
		} catch (NegocioException e) {
			e.printStackTrace();
			makeErrorMessage("ERRO: " + e.getMessage(), "");
		} catch (ValidacaoException e) {
			makeWarnMessage(e.getMessage(),"");
		}
	}
	
	public void adicionarOpcao() {
		opcao.setPreferencia(preferencia);
		opcoes.add(opcao);
		opcao = new Opcao();
	}
	
	public void removerOpcao(Opcao opcao) {
		opcoes.remove(opcao);
	}
	
	public void editar(Preferencia preferenciaSelecionada) {
		try {
			this.preferencia = preferenciaNegocio.obterPorId(preferenciaSelecionada.getId());
		} catch (NegocioException e) {
			e.printStackTrace();
			makeWarnMessage(e.getMessage(), "ERRO");
		}
	}
	
	public void ativar(Preferencia preferenciaSelecionada) {
//		try {
//			preferenciaNegocio.ativar(preferenciaSelecionada);
//			makeInfoMessage("Preferência ativada com sucesso!", "");
//		} catch (NegocioException e) {
//			e.printStackTrace();
//			makeWarnMessage(e.getMessage(), "ERRO");
//		}
	}
	
	public void inativar(Preferencia preferenciaSelecionada) {
//		try {
//			preferenciaNegocio.inativar(preferenciaSelecionada);
//			makeInfoMessage("Preferência inativada com sucesso!", "");
//		} catch (NegocioException e) {
//			e.printStackTrace();
//			makeWarnMessage(e.getMessage(), "ERRO");
//		}
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public ETipoPreferencia[] getTiposPreferencias() {
		return tiposPreferencias;
	}

	public ETipoPreferencia getTipoPreferencia() {
		return tipoPreferencia;
	}

	public void setTipoPreferencia(ETipoPreferencia tipoPreferencia) {
		this.tipoPreferencia = tipoPreferencia;
	}

	public Opcao getOpcao() {
		return opcao;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}
}
