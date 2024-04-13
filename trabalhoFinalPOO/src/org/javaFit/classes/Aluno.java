package org.javaFit.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//subclasse de Pessoa
public class Aluno extends Pessoa {
	private Plano planoContratado;
	private LocalDate dataMatricula;
	private AvaliacaoFisica avaliacaoFisica;
	private List<Avaliacao> avaliacoes;
	private List<Agendamento> agendamentos;

	public Aluno(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
			Plano planoContratado, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.planoContratado = planoContratado;
		this.dataMatricula = dataMatricula;
		this.agendamentos = new ArrayList<>();
		this.avaliacoes = new ArrayList<>();
	}

	public Plano getPlanoContratado() {
		return planoContratado;
	}

	public void setPlanoContratado(Plano planoContratado) {
		this.planoContratado = planoContratado;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public void addAvaliacao(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);

	}

	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

	// métodos
	public void menuAluno() {
		System.out.printf("1-Editar\n2-Sair");
	}

	/**
	 * Exibe os dados pessoais.
	 */

	public void vizualizarDadosPessoais() {
		System.out.printf("""
				Nome: %s
				Cpf: %s
				Data Nascimento: %s
				Contato: %s
				Plano Contratado: %s
				Data de Matricula: %s
				""", nome, cpf, dataNascimento, contato, planoContratado, dataMatricula);
	}

	/**
	 * Solicita um agendamento.
	 * 
	 * @param agendamento O agendamento a ser solicitado.
	 */

	public void solicitarAgendamento(Agendamento agendamento) {
		boolean conflito = false;
		for (Agendamento ag : agendamentos) {
			if (ag.getDataAgendamento().equals(agendamento.getDataAgendamento()) &&
					ag.getHoraAgendamento().equals(agendamento.getHoraAgendamento()))
				conflito = true;
			break;
		}
		if (conflito) {
			System.out.println("Já existe um agendamento para esta data e hora");
		} else {
			agendamentos.add(agendamento);
			System.out.println("Agendamento realizado com sucesso!");
		}
	}

	/**
	 * Exibe o histórico de agendamento.
	 */

	public void vizualizarHistoricoAgendamento() {
		System.out.println("Historico de Agendamento: ");
		for (Agendamento ag : agendamentos) {
			System.out.println("Data: " + ag.getDataAgendamento() +
					"Horario :" + ag.getHoraAgendamento());
		}

	}

	@Override
	public String toString() {
		return super.toString() + String.format("""
				Plano contratado: %s
				Data Matricula: %s
				Avaliações Físicas: %s
				""", planoContratado, dataMatricula, avaliacaoFisica);

	}

}