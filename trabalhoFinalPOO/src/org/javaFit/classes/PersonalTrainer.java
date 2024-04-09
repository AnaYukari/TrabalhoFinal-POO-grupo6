package org.javaFit.classes;
//subclasse de Pessoa
public class PersonalTrainer extends Pessoa {

    private String especialidade;
    private String CREF;
    private String horarioAtendimento;

        public PersonalTrainer(String especialidade, String cref, String horarioAtendimento) {
		this.especialidade = especialidade;
		CREF = cref;
		this.horarioAtendimento = horarioAtendimento;
	}

		public String getEspecialidade() {
			return especialidade;
		}

		public void setEspecialidade(String especialidade) {
			this.especialidade = especialidade;
		}

		public String getCREF() {
			return CREF;
		}

		public void setCREF(String cREF) {
			CREF = cREF;
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
					""", especialidade, CREF, horarioAtendimento);
					
		}

}