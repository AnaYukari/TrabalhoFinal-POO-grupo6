package org.javaFit.classes;

import java.time.LocalDate;
import java.util.List;

//subclasse de Pessoa
public class PersonalTrainer extends Pessoa {

    private Especialidade especialidade;
    private String cref;
    private String horarioAtendimento;
    private List<Agendamento> agendamentos;
        
	public PersonalTrainer(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
			Especialidade especialidade, String cref, String horarioAtendimento) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.especialidade = especialidade;
		this.cref = cref;
		this.horarioAtendimento = horarioAtendimento;
	}

		

		public Especialidade getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(Especialidade especialidade) {
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

	//Método para visualizar agendamentos
	public void visualizarAgendamentos(PersonalTrainer pTrainer, List<Agendamento> agendamentos) {
	    System.out.println("Agendamentos realizados com você:");
	    boolean encontrouAgendamentos = false;
	    
	    for (Agendamento agendamento : agendamentos) {
	        if (agendamento.getPersonalTrainer().equals(this)) {
	            encontrouAgendamentos = true;
	            System.out.println("Data: " + agendamento.getDataAgendamento());
	            System.out.println("Hora: " + agendamento.getHoraAgendamento());
	            System.out.println("Aluno: " + agendamento.getAluno().getNome());
	            System.out.println("--------------------------");
	        }
	    }
	    
	    if (!encontrouAgendamentos) {
	        System.out.println("Nenhum agendamento realizado com você.");
	    }
	}

		@Override
		public String toString() {
			return super.toString() + String.format("""
					Especialidade: %s
					CREF: %s
					Hora de Atendimento: %s
					
					""", especialidade, cref, horarioAtendimento);
					
		}

}