package br.com.brotherhood.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

class BaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected void makeErrorMessage(String mensagem, String titulo) {
		makeMessage(FacesMessage.SEVERITY_ERROR, mensagem, titulo);
	}
	
	protected void makeWarnMessage(String mensagem, String titulo) {
		makeMessage(FacesMessage.SEVERITY_WARN, mensagem, titulo);
	}
	
	protected void makeInfoMessage(String mensagem, String titulo) {
		makeMessage(FacesMessage.SEVERITY_INFO, mensagem, titulo);
	}
	
	private void makeMessage(Severity severity, String mensagem, String titulo) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, mensagem, titulo));
	}
	
}
