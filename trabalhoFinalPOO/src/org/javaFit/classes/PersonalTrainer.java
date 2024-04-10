package org.javaFit.classes;

import java.time.LocalDate;

//subclasse de Pessoa
public class PersonalTrainer extends Pessoa {

    private String especialidade;
    private String cref;
    private String horarioAtendimento;

        
	public PersonalTrainer(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
			String especialidade, String cref, String horarioAtendimento) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.especialidade = especialidade;
		this.cref = cref;
		this.horarioAtendimento = horarioAtendimento;
	}

		

		public String getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	public String getCref() {
		return cref;
	}



	public void setCref(String cref) {
		this.cref = cref;
	}



	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}



	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}



		@Override
		public String toString() {
			return String.format("""
					Especialidade: %s
					CREF: %s
					Hora de Atendimento: %s
					""", especialidade, cref, horarioAtendimento);
					
		}

}