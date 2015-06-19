package br.com.brotherhood.entidade;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta_opcao")
public class RespostaOpcao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn (name = "_resposta_usuario", 
					referencedColumnName = "_usuario"),
		@JoinColumn (name = "_resposta_preferencia", 
					referencedColumnName = "_preferencia") })
	private Resposta resposta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_opcao")
	private Opcao opcao;
	
	
}
