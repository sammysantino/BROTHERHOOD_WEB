package br.com.brotherhood.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RespostaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "_usuario")
	private Integer idUsuario;
	
	@Column(name = "_preferencia")
	private Integer idPreferencia;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdPreferencia() {
		return idPreferencia;
	}

	public void setIdPreferencia(Integer idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPreferencia == null) ? 0 : idPreferencia.hashCode());
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		RespostaPk other = (RespostaPk) obj;
		if (idPreferencia == null) {
			if (other.idPreferencia != null)
				return false;
		} else if (!idPreferencia.equals(other.idPreferencia))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RespostaPk [idUsuario=" + idUsuario + ", idPreferencia="
				+ idPreferencia + "]";
	}
	
}
