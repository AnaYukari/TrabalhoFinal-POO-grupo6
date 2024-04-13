package org.javaFit.classes;

public enum Especialidade {
	EMAGRECIMENTO("Emagrecimento"),
	HIPERTROFIA_MUSCULAR("Hipertrofia Muscular"),
	CONDICIONAMENTO_FISICO("Condicionamento Físico"),
	REABILITACAO_FISICA("Reabilitação Física");
	
	private String descricaoTextutal;
	
	Especialidade(String descricaoTextual) {
		this.descricaoTextutal = descricaoTextual;
	}

	public String getDescricaoTextutal() {
		return descricaoTextutal;
	}
}
