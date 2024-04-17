package org.javaFit.classes;

public class Plano {
	private String nomePlano;
	private double valorPlano;
	private String descricaoPlano;

	public Plano(String nomePlano, double valorPlano, String descricaoPlano) {
		this.nomePlano = nomePlano;
		this.valorPlano = valorPlano;
		this.descricaoPlano = descricaoPlano;
	}

	public double getValorPlano() {
		return valorPlano;
	}

	public double setValorPlano(double valorPlano) {
		return this.valorPlano = valorPlano;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public String getDescricaoPlano() {
		return descricaoPlano;
	}

	@Override
	public String toString() {
		return String.format("""
				Plano: %s
				Valor do Plano: R$%.2f
				Descrição do Plano: %s""", nomePlano, valorPlano, descricaoPlano);
	}
}