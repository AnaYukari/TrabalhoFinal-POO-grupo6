package org.javaFit.classes;

import java.time.LocalDate;

//subclasse de Pessoa
public class Aluno extends Pessoa {
	private Plano planoContratado;
	private LocalDate dataMatricula;
	private AvaliacaoFisica avaliacaoFisica;
	private int duracaoPlano;

    public Aluno(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
			Plano planoContratado, int duracaoPlano, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.planoContratado = planoContratado;
		this.duracaoPlano = duracaoPlano;
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
    

	public  void vizualizarDadosPessoais() {
		System.out.printf("""
				Nome: %s.
				CPF: %s.
				Data de Nascimento: %s.
				Contato: %s .
				Data de Matricula: %s.
				Plano Contratado: %s.
				Duração do Plano: %d meses.
				Valor do Plano: R$%.2f.
				Descrição do Plano: %s
				
				
				""", getNome(), getCpf(), getDataMatricula(), getContato(), getDataMatricula(), getPlanoContratado().getNomePlano(), getDuracaoPlano(), aplicarDesconto(), getPlanoContratado().getDescricaoPlano() );
		
		
//		System.out.println("Dados pessoais:\n");
//        System.out.println("Nome: " + aluno.getNome());
//        System.out.println("CPF: " + aluno.getCpf());
//        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
//        System.out.println("Contato: " + aluno.getContato() + "\n");
//        System.out.println("Plano Contratado: " + aluno.getPlanoContratado().getNomePlano());
//        System.out.println("Duração do Plano: " + aluno.getDuracaoPlano() + " meses");
//        System.out.println("Valor do Plano: R$" + aluno.getPlanoContratado().getValorPlano());
//        System.out.println("Descrição do Plano: " + aluno.getPlanoContratado().getDescricaoPlano());
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
        } else if (duracaoPlano < 6) {
        	valorComDesconto = planoContratado.getValorPlano();
        }
       	planoContratado.setValorPlano(valorComDesconto);
        return valorComDesconto;
    }


	@Override
	public String toString() {
		return String.format("""
				Nome: %s.
				CPF: %s.
				Data de Nascimento: %s.
				Contato: %s .
				Data de Matricula: %s.
				Plano Contratado: %s.
				Duração do Plano: %d meses.
				Valor do Plano: R$%.2f.
				Descrição do Plano: %s
				
				
				""", getNome(), getCpf(), getDataMatricula(), getContato(), getDataMatricula(), getPlanoContratado().getNomePlano(), getDuracaoPlano(), aplicarDesconto(), getPlanoContratado().getDescricaoPlano() );
		
	}

}