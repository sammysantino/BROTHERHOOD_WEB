package br.com.brotherhood.entidade;

import javax.persistence.Entity;
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
}
