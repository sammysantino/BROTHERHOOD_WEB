package br.com.brotherhood.entidade;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RespostaPk {

	@Column(name = "_usuario")
	private Integer idUsuario;
	
	@Column(name = "_preferencia")
	private Integer idPreferencia;
	
}
