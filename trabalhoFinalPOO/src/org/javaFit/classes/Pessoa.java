package org.javaFit.classes;

import java.time.LocalDate;

//classe mãe de Aluno, Funcionario e PersonalTrainer
public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String contato;
    private String senha;

    public Pessoa(String nome, String cpf, LocalDate dataDeNascimento, String contato, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.contato = contato;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
