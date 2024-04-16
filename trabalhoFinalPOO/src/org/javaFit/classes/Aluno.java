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
	private List<Avaliacao> avaliacoes;
	private List<Agendamento> agendamentos;
	private int duracaoPlano;
	private List<PersonalTrainer> personalTrainers;

    public Aluno(String nome, String cpf, LocalDate dataNascimento, String contato, String senha,
			Plano planoContratado, int duracaoPlano, LocalDate dataMatricula) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.planoContratado = planoContratado;
		this.duracaoPlano = duracaoPlano;
		this.dataMatricula = dataMatricula;
		this.agendamentos = new ArrayList<>();
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
    
    public void setPersonalTrainers(List<PersonalTrainer> personalTrainers) {
        this.personalTrainers = personalTrainers;
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
	   //Método para solicitar agendamento
	   public void solicitarAgendamento() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Lista de Personal Trainers Disponíveis:");
	        for (int i = 0; i < personalTrainers.size(); i++) {
	            System.out.println((i + 1) + ". " + personalTrainers.get(i).getNome() + " - " + personalTrainers.get(i).getEspecialidade() + " - " + personalTrainers.get(i).getHorarioAtendimento());
	        }

	        System.out.print("Escolha o número correspondente ao Personal Trainer desejado: ");
	        int escolhaPersonalTrainer = scanner.nextInt();

	        if (escolhaPersonalTrainer < 1 || escolhaPersonalTrainer > personalTrainers.size()) {
	            System.out.println("Escolha inválida. Por favor, tente novamente.");            
	            return;	        
	        }

	        PersonalTrainer personalTrainerEscolhido = personalTrainers.get(escolhaPersonalTrainer - 1);
	        LocalDate dataAgendamento;
	        LocalTime horaAgendamento;

	        
	        while (true) {
	        	 System.out.print("Digite a data do agendamento (AAAA-MM-DD): ");	       
	        	 String dataString1 = scanner.next();

	            try {
	                dataAgendamento = LocalDate.parse(dataString1);
	                break;
	                
	            } catch (DateTimeParseException e) {
	                System.out.println("Formato de data inválido. Tente novamente.");
	            }
	        }
        
	        while (true) {
	        	  System.out.print("Digite a hora do agendamento (HH:MM): ");
	        	  String horaString1 = scanner.next();

	            try {
	                horaAgendamento = LocalTime.parse(horaString1);
	                break;
	                
	            } catch (DateTimeParseException e) {
	                System.out.println("Formato de hora inválido. Tente novamente.");
	            }
	        }
	        
	        Agendamento novoAgendamento = new Agendamento(this, personalTrainerEscolhido, dataAgendamento, horaAgendamento);
	        agendamentos.add(novoAgendamento);

	        System.out.println("Agendamento realizado com sucesso!");
	   }
	
	
	//Método para visualizar histórico de agendamentos
	    public void visualizarHistoricoAgendamentos() {
	        if (agendamentos.isEmpty()) {
	            System.out.println("Nenhum agendamento encontrado.");
	            return;
	        } else {
	            System.out.println("Histórico de Agendamentos:");
	            for (Agendamento agendamento : agendamentos) {
	                System.out.println(agendamento);
	            }
	        }
	    }
	    //Método para selecionar e cancelar agendamento
	    public void cancelarAgendamento(){
	        if (agendamentos.isEmpty()) {
	            System.out.println("Não há agendamentos disponíveis.");
	            return;
	        }

	        System.out.println("Seus agendamentos:");

	        for (int i = 0; i < agendamentos.size(); i++) {
	        		if((agendamentos.get(i).getDataAgendamento()).isAfter(LocalDate.now())) {
	        			Agendamento agendamento = agendamentos.get(i);
	        			System.out.println((i + 1) + ". Data: " + agendamento.getDataAgendamento() +
	        										", Hora: " + agendamento.getHoraAgendamento() +
	        										", Personal Trainer: " + agendamento.getPersonalTrainer().getNome());
	        }

	        int escolha = getIntInput("Escolha o número do agendamento que deseja cancelar (0 para sair): ");

	        if (escolha == 0) {
	            return;
	        }

	        if (escolha < 1 || escolha > agendamentos.size()) {
	            System.out.println("Escolha inválida. Tente novamente.");
	            return;
	        }

	        Agendamento agendamentoSelecionado = agendamentos.get(escolha - 1);
	        System.out.println("Agendamento selecionado:");
	        System.out.println("Data: " + agendamentoSelecionado.getDataAgendamento());
	        System.out.println("Hora: " + agendamentoSelecionado.getHoraAgendamento());
	        System.out.println("Personal Trainer: " + agendamentoSelecionado.getPersonalTrainer().getNome());

	        agendamentos.remove(agendamentoSelecionado);
	        System.out.println("Agendamento cancelado com sucesso.");
	    }
	    }

	    // Método para entrada de inteiros
	    private int getIntInput(String prompt) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print(prompt);
	        while (!scanner.hasNextInt()) {
	            System.out.println("Entrada inválida. Digite um número inteiro.");
	            System.out.print(prompt);
	            scanner.next();
	        }
	        return scanner.nextInt();
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