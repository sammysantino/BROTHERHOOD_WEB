package br.com.brotherhood.entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private ESituacao situacao = ESituacao.ATIVO;
	
	public void validar() throws ValidacaoException {
		if ((this.titulo == null) 
				|| (this.titulo.isEmpty())) {
			throw new ValidacaoException("Título é obrigatório!");
		}
		
		if ((this.descricao == null) 
				|| (this.descricao.isEmpty())) {
			throw new ValidacaoException("Descrição é obrigatória!");
		}
	}
	
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

	public ESituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(ESituacao situacao) {
		this.situacao = situacao;
	}
}
