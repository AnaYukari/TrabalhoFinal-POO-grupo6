package org.javaFit.classes;

import java.time.LocalDate;

//classe ligada com Aluno e PersonalTrainer
public class Avaliacao {
	
		private Aluno aluno;
	    private LocalDate data;
	    private PersonalTrainer personalTrainer;
	    private String descricao;
	    
		public Avaliacao(Aluno aluno, LocalDate data, PersonalTrainer personalTrainer, String descricao) {
			this.aluno = aluno;
			this.data = data;
			this.personalTrainer = personalTrainer;
			this.descricao = descricao;
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

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		@Override
		public String toString() {
			return String.format("""
					Aluno: %s
					Data: %s
					Personal trainer: %s
					Descrição: %s
					""", aluno, data, personalTrainer, descricao);
		}
	    
	    
	    

}