package org.javaFit.classes;

import java.time.LocalDate;

public class AvaliacaoFisica   {
	private double altura;
	private double peso;
	double imc;
	double percentualGordura;
	double massaMuscular;
	String observacoes;
	LocalDate dataAvaliacao;
	
	public AvaliacaoFisica(double altura, double peso, double imc, double percentualGordura, double massaMuscular, String observacoes, LocalDate dataAvaliacao) {
	
		this.altura = altura;
		this.peso = peso;
		this.imc = peso / (altura * altura);
		this.percentualGordura = percentualGordura;
		this.massaMuscular = massaMuscular;
		this.observacoes = observacoes;
		this.dataAvaliacao = dataAvaliacao;
	}


	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	
	public double getImc() {
		return imc;
	}



	public void setImc(double imc) {
		this.imc = imc;
	}



	public double getPercentualGordura() {
		return percentualGordura;
	}



	public void setPercentualGordura(double percentualGordura) {
		this.percentualGordura = percentualGordura;
	}



	public double getMassaMuscular() {
		return massaMuscular;
	}



	public void setMassaMuscular(double massaMuscular) {
		this.massaMuscular = massaMuscular;
	}



	public String getObservacoes() {
		return observacoes;
	}



	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	

	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}



	public void setDataAvaliacao(LocalDate dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}



	@Override
	public String toString() {
		return "Avaliacao Física\n\nAltura: " + altura + " m\nPeso: " + peso + "kg\nIMC: " + imc
				+ "Percentual de Gordura: " + percentualGordura + "Massa Muscular: " + massaMuscular + "Observaçõe: "
				+ observacoes;
	}



	



}