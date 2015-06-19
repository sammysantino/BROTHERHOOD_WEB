package br.com.brotherhood.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta {
	
	@Id
	private RespostaPk id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_preferencia", insertable = false, updatable = false)
	private Preferencia preferencia;
	
	@Column(name = "texto_resposta")
	private String textoResposta;
	

}
