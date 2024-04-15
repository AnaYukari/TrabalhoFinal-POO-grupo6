package org.javaFit.classes;


import java.time.LocalDate;
import java.time.LocalTime;


public class Agendamento {
	private LocalDate dataAgendamento;
	private LocalTime horaAgendamento;
	private Aluno aluno;
	private PersonalTrainer personalTrainer;
	
	public Agendamento(Aluno aluno, PersonalTrainer personalTrainer, LocalDate dataAgendamento,LocalTime horaAgendamento) {
		this.aluno = aluno;
		this.personalTrainer = personalTrainer;
		this.dataAgendamento = dataAgendamento;
		this.horaAgendamento = horaAgendamento;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalTime getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(LocalTime horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}

	public void setPersonalTrainer(PersonalTrainer personalTrainer) {
		this.personalTrainer = personalTrainer;
	}

	public Aluno getAluno() {
		return aluno;
	}

	@Override
	public String toString() {
		return String.format("""
					Nome do aluno: %s
					Nome personal trainer: %s
					Data do agendamento: %s
					Hora do agendamento: %s
					""", aluno.getNome(), personalTrainer.getNome(), dataAgendamento, horaAgendamento);
				
	}
	
	
	
	
}