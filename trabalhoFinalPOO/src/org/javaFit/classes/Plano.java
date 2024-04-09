package org.javaFit.classes;
//classe ligada com Aluno
public class Plano {
	private String nomePlano; //nome do plano
	private int duracaoPlano; //duração do plano em meses
	private double valorPlano; //valor do plano mensal
	private String descricaoPlano; //descrição do plano
	
	public Plano(String nomePlano, double valorPlano, String descricaoPlano) {
		this.nomePlano = nomePlano;
		this.valorPlano = valorPlano;
		this.descricaoPlano = descricaoPlano;
	}

	public int getDuracaoPlano() {
		return duracaoPlano;
	}

	public void setDuracaoPlano(int duracaoPlano) {
		this.duracaoPlano = duracaoPlano;
	}

	public double getValorPlano() {
		return valorPlano;
	}

	public void setValorPlano(double valorPlano) {
		this.valorPlano = valorPlano;
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
				Duração do Plano: %d meses.
				Valor do Plano: R$%.2f
				Descrição do Plano: %s
				""", nomePlano, duracaoPlano, valorPlano, descricaoPlano);
		}

	
}
