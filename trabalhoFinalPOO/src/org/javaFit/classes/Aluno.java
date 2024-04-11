package org.javaFit.classes;

import java.time.LocalDate;
import java.util.List;

//subclasse de Pessoa
public class Aluno extends Pessoa {
	 	private Plano planoContratado;
	    private LocalDate dataMatricula;
	    private List<Avaliacao> avaliacoes;
		
	    public Aluno(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
				Plano planoContratado, LocalDate dataMatricula) {
			super(nome, cpf, dataNascimento, contato, senha);
			this.planoContratado = planoContratado;
			this.dataMatricula = dataMatricula;
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

		@Override
		public String toString() {
			return super.toString() + String.format("""
					Plano contratado: %s
					Data Matricula: %s
					Avaliações: %s
					""", planoContratado, dataMatricula, avaliacoes);
					
				
		}
			
	    
}