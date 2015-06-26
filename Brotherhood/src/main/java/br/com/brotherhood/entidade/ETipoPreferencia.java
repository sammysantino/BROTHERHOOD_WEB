package br.com.brotherhood.entidade;

public enum ETipoPreferencia {
	MULTIPLA_ESCOLHA("Múltipla Escolha", true),
	UNICA_ESCOLHA_COMBO("Única Escolha Combo", true),
	UNICA_ESCOLHA_RADIO("Única Escolha Radio", true),
	SUBJETIVA_TEXTO("Texto", false),
	SUBJETIVA_INTEIRO("Número", false);
	
	private String descricao;
	private boolean possuiOpcoes;
	
	ETipoPreferencia(String descricao, boolean possuiOpcoes) {
		this.descricao = descricao;
		this.possuiOpcoes = possuiOpcoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isPossuiOpcoes() {
		return possuiOpcoes;
	}

}
