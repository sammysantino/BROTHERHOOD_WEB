package br.com.brotherhood.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="preferencia")
public class Preferencia {

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
}
