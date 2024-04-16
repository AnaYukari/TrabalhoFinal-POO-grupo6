package org.javaFit.classes;

import java.time.LocalDate;
import java.util.List;

//classe ligada com Aluno e PersonalTrainer
public class Avaliacao {
	
		private Aluno aluno;
	    private LocalDate data;
	    private PersonalTrainer personalTrainer;
	    private AvaliacaoFisica avaliacaoFisicas;
	    
		public Avaliacao(Aluno aluno, LocalDate data, PersonalTrainer personalTrainer, AvaliacaoFisica avaliacaoFisicas) {
			this.aluno = aluno;
			this.data = data;
			this.personalTrainer = personalTrainer;
			this.avaliacaoFisicas = avaliacaoFisicas;
		}

		public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate data) {
			this.data = data;
		}

		public PersonalTrainer getPersonalTrainer() {
			return personalTrainer;
		}

		public void setPersonalTrainer(PersonalTrainer personalTrainer) {
			this.personalTrainer = personalTrainer;
		}

		public AvaliacaoFisica getAvaliacaoFisicas() {
			return avaliacaoFisicas;
		}

		public void setAvaliacaoFisicas(AvaliacaoFisica avaliacaoFisicas) {
			this.avaliacaoFisicas = avaliacaoFisicas;
		}

		
		
		public String toString() {
			return String.format("""
					Aluno: %s
					Data: %s
					Personal trainer: %s
					Descrição: %s
					""", aluno, data, personalTrainer, avaliacaoFisicas);
		}
		
}

		