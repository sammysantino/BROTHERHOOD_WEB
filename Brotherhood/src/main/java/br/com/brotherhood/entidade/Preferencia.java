package br.com.brotherhood.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="preferencia")
public class Preferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private ESituacao situacao;
	
	@Enumerated(EnumType.STRING)
	private ETipoPreferencia tipoPreferencia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "preferencia", cascade = CascadeType.PERSIST)
	private List<Opcao> opcoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ESituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(ESituacao situacao) {
		this.situacao = situacao;
	}

	public ETipoPreferencia getTipoPreferencia() {
		return tipoPreferencia;
	}

	public void setTipoPreferencia(ETipoPreferencia tipoPreferencia) {
		this.tipoPreferencia = tipoPreferencia;
	}

	public void validar() throws ValidacaoException {
		
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preferencia other = (Preferencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Preferencia [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", situacao=" + situacao + ", tipoPreferencia="
				+ tipoPreferencia + ", categoria=" + categoria + ", opcoes="
				+ opcoes + "]";
	}
}
