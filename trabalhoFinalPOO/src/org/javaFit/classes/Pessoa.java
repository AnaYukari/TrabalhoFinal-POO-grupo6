package org.javaFit.classes;

import javax.xml.crypto.Data;

//classe mãe de Aluno, Funcionario e PersonalTrainer
public class Pessoa {
    private String nome;
    private String cpf;
    private Data dataDeNascimento;
    private String contato;
    private String senha;

    public Pessoa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Data getDataDeNascimento() {
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
