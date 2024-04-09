package org.javaFit.classes;

import java.time.LocalDate;

//classe mãe de Aluno, Funcionario e PersonalTrainer
public class Pessoa {
		private String nome;
	    private String cpf;
	    private LocalDate dataNascimento;
	    private String contato;
	    private String senha;
	    
		public Pessoa(String nome, String cpf, LocalDate dataNascimento, String contato, String senha) {
			this.nome = nome;
			this.cpf = cpf;
			this.dataNascimento = dataNascimento;
			this.contato = contato;
			this.senha = senha;
		}

}