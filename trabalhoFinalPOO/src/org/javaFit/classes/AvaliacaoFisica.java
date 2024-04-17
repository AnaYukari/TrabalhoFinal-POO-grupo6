package org.javaFit.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvaliacaoFisica {
	private Aluno aluno;
	private LocalDate data;
	private PersonalTrainer personalTrainer;
	private double altura;
	private double peso;
	private double imc;
	private double percentualGordura;
	private double massaMuscular;
	private String observacoes;
	private static List<AvaliacaoFisica> historicoAvaliacao = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public AvaliacaoFisica(Aluno aluno, LocalDate data, PersonalTrainer personalTrainer, double altura, double peso,
			double imc, double percentualGordura, double massaMuscular, String observacoes) {
		this.aluno = aluno;
		this.data = data;
		this.personalTrainer = personalTrainer;
		this.altura = altura;
		this.peso = peso;
		this.imc = peso / (altura * altura);
		this.percentualGordura = percentualGordura;
		this.massaMuscular = massaMuscular;
		this.observacoes = observacoes;

	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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

	public Aluno getAluno() {
		return aluno;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}

	public double getImc() {
		return imc;
	}

	public static List<AvaliacaoFisica> getHistoricoAvaliacao() {
		return historicoAvaliacao;
	}

	public void setHistoricoAvaliacao(List<AvaliacaoFisica> historicoAvaliacao) {
		AvaliacaoFisica.historicoAvaliacao = historicoAvaliacao;
	}

	@Override
	public String toString() {
		return String.format("""
				Aluno(a): %s.
				Personal Trainer: %s.
				Data da avaliação: %s.
				Altura: %.2fM.
				Peso:  %.2fKg.
				Imc:  %.2f.
				Percentual de Gordura: %.2f .
				Massa Muscular:  %.2fKg.
				""", aluno.getNome(), personalTrainer.getNome(), data.format(dateFormat), altura, peso, imc,
				percentualGordura, massaMuscular);
	}

	public static void adicionaAvaliacao(Aluno alunoParaAvaliar, PersonalTrainer ptrainer) {
		System.out.println("\nAvaliação do(a) aluno(a) " + alunoParaAvaliar.getNome() + "\n");
		double peso = naoNegativoDoubleInput("Peso (em kg): ");
		double altura = naoNegativoDoubleInput("Altura (em metro): ");
		double imc = peso / (altura * altura);
		double percentualGordura = naoNegativoDoubleInput("Percentual de gordura corporal (%): ");
		double massaMuscular = naoNegativoDoubleInput("Massa muscular (em kg): ");
		String observacoes = getInput("Observações: ");
		LocalDate dataAvaliacao = LocalDate.now();

		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica(alunoParaAvaliar, dataAvaliacao, ptrainer, altura, peso,
				imc, percentualGordura, massaMuscular, observacoes);

		alunoParaAvaliar.setAvaliacaoFisica(avaliacaoFisica);
		historicoAvaliacao.add(avaliacaoFisica);
		System.out.println(
				"Avaliação física registrada com sucesso para o(a) aluno(a) " + alunoParaAvaliar.getNome() + "!");

	}
	private static double naoNegativoDoubleInput(String prompt) {
	    double valor;
	    do {
	        System.out.print(prompt);
	        while (!scanner.hasNextDouble()) {
	            System.out.println("Por favor, insira um número válido maior ou igual a zero.");
	            System.out.print(prompt);
	            scanner.next();
	        }
	        valor = scanner.nextDouble();
	        if (valor < 0) {
	            System.out.println("Por favor, insira um número maior ou igual a zero.");
	        }
	    } while (valor < 0);
	    return valor;
	}

	public static void visualizarAvaliacoesRealizadasAluno(Aluno aluno) {
		System.out.println("Lista de avaliações físicas realizadas:\n");

		boolean avaliacoesEncontradas = false;

		for (AvaliacaoFisica avaliacaoFisica : historicoAvaliacao) {
			if (avaliacaoFisica.getAluno() == aluno) {
				avaliacoesEncontradas = true;
				System.out.println("Data: " + avaliacaoFisica.getData().format(dateFormat));
				System.out.println("Peso: " + avaliacaoFisica.getPeso() + "kg");
				System.out.println("Altura: " + avaliacaoFisica.getAltura() + "m");
				System.out.printf("IMC: %.2f\n", avaliacaoFisica.getImc());
				System.out.println("Percentual de Gordura Corporal: " + avaliacaoFisica.getPercentualGordura() + "%");
				System.out.println("Massa Muscular: " + avaliacaoFisica.getMassaMuscular() + " kg");
				System.out.println("Observações: " + avaliacaoFisica.getObservacoes());
				System.out.println("===============================================\n");
			}
		}
		if (!avaliacoesEncontradas) {
			System.out.println("Nenhuma avaliação física registrada para o(a) aluno(a) " + aluno.getNome() + ".");
		}
	}

	public static void visualizarAvaliacoesRealizadasPersonalTrainer(PersonalTrainer ptrainer) {
		System.out.println("Lista de avaliações físicas registradas por: " + ptrainer + "\n");

		boolean avaliacoesEncontradas = false;

		for (AvaliacaoFisica avaliacaoFisica : historicoAvaliacao) {
			if (avaliacaoFisica.getPersonalTrainer() == ptrainer) {
				avaliacoesEncontradas = true;
				System.out.println("Data: " + avaliacaoFisica.getData().format(dateFormat));
				System.out.println("Peso: " + avaliacaoFisica.getPeso() + "kg");
				System.out.println("Altura: " + avaliacaoFisica.getAltura() + "m");
				System.out.printf("IMC: %.2f ", avaliacaoFisica.getImc(), "\n");
				System.out.println("Percentual de Gordura Corporal: " + avaliacaoFisica.getPercentualGordura() + "%");
				System.out.println("Massa Muscular: " + avaliacaoFisica.getMassaMuscular() + " kg");
				System.out.println("Observações: " + avaliacaoFisica.getObservacoes());
				System.out.println("===============================================\n");
			}
		}
		if (!avaliacoesEncontradas) {
			System.out.println("Você ainda não registrou nenhuma avaliação.");
		}
	}

	private static String getInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}
}