package br.com.brotherhood.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta {
	
	@Id
	private RespostaPk id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_ficha_informacao", foreignKey = @ForeignKey(name = "fk_ficha_informacao"), 
	insertable = false, updatable = false)
	private FichaInformacao fichaInformacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_ficha_informacao_pergunta", 
	foreignKey = @ForeignKey(name = "fk_ficha_informacao_pergunta"), insertable = false, updatable = false)
	private FichaInformacaoPergunta fichaInformacaoPergunta;
	
	@Column(name = "texto_resposta")
	private String textoResposta;
	
	@ManyToOne
	private Usuario usuario;
	
	//private Preferencia preferencia;

}
