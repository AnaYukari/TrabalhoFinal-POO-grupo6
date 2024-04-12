package org.javaFit.classes;

public class AvaliacaoFisica implements AdicionaAvaliacaoFisica {
	private double altura;
	private double peso;
	private String situacaoImc;
	
	public AvaliacaoFisica(double altura, double peso) {
		this.altura = altura;
		this.peso = peso;
	}
	
	 double imc = peso/(altura*altura);

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
	
	public String calculaSituacao() {
		if (imc >= 40.0) {
			situacaoImc = "O IMC dessa pessoa é: %.2f - Obesidade Grau 3.";
		}else if(imc >= 35.0) {
			situacaoImc = "O IMC dessa pessoa é: %.2f - Obesidade Grau 2.";
		}else if(imc >= 30.0) {
			situacaoImc = "O IMC dessa pessoa é: %.2f -  Obesidade Grau 1.";
		}else if(imc >= 25.0) {
			situacaoImc = "O IMC dessa pessoa é: %.2f - Pré-obesidade.";
		}else if(imc >= 18.5) {
			situacaoImc = "O IMC dessa pessoa é: %.2f - Peso Normal.";
		}
		return situacaoImc;
	}
	

	
	@Override
	public String toString() {
		return "AvaliacaoFisica [altura=" + altura + ", peso=" + peso + ", imc=" + imc + "Situação do Aluno: " + calculaSituacao() ;
	}

	
	@Override
	public void AdicionaAvaliacao(Aluno aluno, double peso, double altura) {
		setPeso(peso);
		setAltura(altura);
	
		
	}
	
	
}