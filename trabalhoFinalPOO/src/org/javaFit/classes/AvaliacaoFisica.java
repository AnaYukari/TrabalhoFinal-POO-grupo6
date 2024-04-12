package org.javaFit.classes;

public class AvaliacaoFisica implements AdicionaAvaliacaoFisica {
	private double altura;
	private double peso;
	private String situacaoImc;
	
	public AvaliacaoFisica(double altura, double peso) {
		this.altura = altura;
		this.peso = peso;
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
	 
	public String calculaSituacao() {
		double imc = peso / (altura*altura);
		if (imc >= 40.0) {
			situacaoImc = String.format("O IMC dessa pessoa é: %.2f - Obesidade Grau 3.", imc);
		}else if(imc >= 35.0) {
			situacaoImc = String.format("O IMC dessa pessoa é: %.2f - Obesidade Grau 2.", imc);
		}else if(imc >= 30.0) {
			situacaoImc = String.format("O IMC dessa pessoa é: %.2f -  Obesidade Grau 1.", imc);
		}else if(imc >= 25.0) {
			situacaoImc = String.format("O IMC dessa pessoa é: %.2f - Pré-obesidade.", imc);
		}else if(imc >= 18.5) {
			situacaoImc = String.format("O IMC dessa pessoa é: %.2f - Peso Normal.", imc);
		}
		return situacaoImc;
	}
	
	
	@Override
	public String toString() {
		return String.format("\nAltura: %.2fm\nPeso: %.2fkg\nIMC: %.2f\nSituação do Aluno: %s", altura, peso, peso / (altura*altura), calculaSituacao());
	}

	
	@Override
	public void AdicionaAvaliacao(Aluno aluno, double peso, double altura) {
		setPeso(peso);
		setAltura(altura);
	
		
	}
	
	
}