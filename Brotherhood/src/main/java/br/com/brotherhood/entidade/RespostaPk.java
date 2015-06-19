package br.com.brotherhood.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RespostaPk implements Serializable {

	@Column(name = "_usuario")
	private Integer idUsuario;
	
	@Column(name = "_preferencia")
	private Integer idPreferencia;
	
}
