package org.javaFit.classes;

import java.time.LocalDate;

//subclasse de Pessoa
public class PersonalTrainer extends Pessoa {

    private String especialidade;
    private String CREF;
    private String horarioAtendimento;

    public PersonalTrainer(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
            String especialidade, String CREF, String horarioAtendimento) {
        super(nome, cpf, dataNascimento, contato, senha);
        this.especialidade = especialidade;
        this.CREF = CREF;
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

    public void setCREF(String CREF) {
        this.CREF = CREF;
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
