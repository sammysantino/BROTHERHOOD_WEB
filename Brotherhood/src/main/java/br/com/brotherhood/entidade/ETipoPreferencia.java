package br.com.brotherhood.entidade;

public enum ETipoPreferencia {
	MULTIPLA_ESCOLHA("Múltipla Escolha"),
	UNICA_ESCOLHA_COMBO("Única Escolha Combo"),
	UNICA_ESCOLHA_RADIO("Única Escolha Radio"),
	SUBJETIVA_TEXTO("Texto"),
	SUBJETIVA_INTEIRO("Número");
	
	private String descricao;
	
	ETipoPreferencia(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
