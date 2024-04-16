package org.javaFit.classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//subclasse de Pessoa
public class Aluno extends Pessoa {
	private Plano planoContratado;
	private LocalDate dataMatricula;
	private AvaliacaoFisica avaliacaoFisica;
	private List<Avaliacao> avaliacoes;;
	private int duracaoPlano;

    public Aluno(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
			Plano planoContratado, int duracaoPlano, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.planoContratado = planoContratado;
		this.duracaoPlano = duracaoPlano;
		this.dataMatricula = dataMatricula;
		this.avaliacoes = new ArrayList<>();
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

	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

    public int getDuracaoPlano() {
        return duracaoPlano;
    }

    public void setDuracaoPlano(int duracaoPlano) {
        this.duracaoPlano = duracaoPlano;
    }
    

	public void vizualizarDadosPessoais() {
		System.out.printf("""
				Nome: %s
				Cpf: %s
				Data Nascimento: %s
				Contato: %s
				Plano Contratado: %s
				Data de Matricula: %s
				
				""", nome, cpf, dataNascimento, contato, planoContratado, dataMatricula);
	}


    //Método para aplicar desconto conforme duração do plano
	//!!!!!! Pedir ajuda com desconto para valores de plano !!!!!!!!!!!!!!!!!!
    public double aplicarDesconto() {
        double valorComDesconto = planoContratado.getValorPlano();
        if (duracaoPlano >= 6 && duracaoPlano < 12) {
            valorComDesconto /= 1.1;
        } else if (duracaoPlano >= 12 && duracaoPlano < 24) {
            valorComDesconto /= 1.2;
        } else if (duracaoPlano >= 24) {
            valorComDesconto /= 1.3;
        }
        Plano plano = new Plano(contato, valorComDesconto, contato);
        plano.setValorPlano(valorComDesconto);
        return valorComDesconto;
    }


	@Override
	public String toString() {
		return super.toString() + String.format("""
				Plano contratado: %s
				Duração do plano: %d meses
				Data Matricula: %s
				Avaliações Físicas: %s
				
				""", planoContratado, duracaoPlano, dataMatricula, avaliacaoFisica);

	}

}