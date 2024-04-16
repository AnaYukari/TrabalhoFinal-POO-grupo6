package org.javaFit.classes;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Agendamento {
	private LocalDate dataAgendamento;
	private LocalTime horaAgendamento;
	private Aluno aluno;
	private PersonalTrainer personalTrainer;
	private Avaliacao avaliacao;
	private static List<PersonalTrainer> personalTrainers;
	protected static List<Agendamento> agendamentos = new ArrayList<>();
	
	public Agendamento(Aluno aluno, PersonalTrainer personalTrainer, LocalDate dataAgendamento,LocalTime horaAgendamento) {
		this.aluno = aluno;
		this.personalTrainer = personalTrainer;
		this.dataAgendamento = dataAgendamento;
		this.horaAgendamento = horaAgendamento;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalTime getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(LocalTime horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}

	public void setPersonalTrainer(PersonalTrainer personalTrainer) {
		this.personalTrainer = personalTrainer;
	}

	public Aluno getAluno() {
		return aluno;
	}
	

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public static List<PersonalTrainer> getPersonalTrainers() {
		return personalTrainers;
	}
	

	public static void setPersonalTrainers(List<PersonalTrainer> personalTrainers) {
		Agendamento.personalTrainers = personalTrainers;
	}
	

	@Override
	public String toString() {
		return String.format("""
					Nome do aluno: %s
					Nome personal trainer: %s
					Data do agendamento: %s
					Hora do agendamento: %s
					""", aluno.getNome(), personalTrainer.getNome(), dataAgendamento, horaAgendamento);
				
	}
	
	//Método para solicitar agendamento
	   public static void  solicitarAgendamento(Aluno aluno) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Lista de Personal Trainers Disponíveis:");
	        for (int i = 0; i < personalTrainers.size(); i++) {
	            System.out.println((i + 1) + ". " + personalTrainers.get(i).getNome() + " - " + personalTrainers.get(i).getEspecialidade() + " - " + personalTrainers.get(i).getHorarioAtendimento());
	        }

	        System.out.print("Escolha o número correspondente ao Personal Trainer desejado: ");
	        int escolhaPersonalTrainer = scanner.nextInt();

	       while (escolhaPersonalTrainer < 1 || escolhaPersonalTrainer > personalTrainers.size()) {
	            System.out.println("Escolha inválida. Por favor, tente novamente.");            
	            	        
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
	        
	        agendamentos.add(new Agendamento(aluno, personalTrainerEscolhido, dataAgendamento, horaAgendamento));

	        System.out.println("Agendamento realizado com sucesso!");
	   }
	   
	//Método para visualizar histórico de agendamentos
	    public static  void visualizarHistoricoAgendamentos(Aluno aluno) {
	        if (agendamentos.isEmpty()) {
	            System.out.println("Nenhum agendamento encontrado.");
	            return;
	        } else {
	            System.out.println("Histórico de Agendamentos:");
	            for (Agendamento agendamento : agendamentos) {
	            	if(agendamento.getAluno() == aluno) {
	            		System.out.println(agendamento);
	            	}
	            }
	        }
	    }

	//Método para selecionar e cancelar agendamento
	    public static void cancelarAgendamento(Aluno aluno){
	        if (agendamentos.isEmpty()) {
	            System.out.println("Não há agendamentos disponíveis.");
	            return;
	        }

	        System.out.println("Seus agendamentos:");

	        for (int i = 0; i < agendamentos.size(); i++) {
	        		if((agendamentos.get(i).getDataAgendamento()).isAfter(LocalDate.now())) {
	        			Agendamento agendamento = agendamentos.get(i);
	        			if(agendamento.getAluno() == aluno) {
	        				System.out.println((i + 1) + ". Data: " + agendamento.getDataAgendamento() +
	        										", Hora: " + agendamento.getHoraAgendamento() +
	        										", Personal Trainer: " + agendamento.getPersonalTrainer().getNome());
	        			}
	        		}
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
	    

	// Método para entrada de inteiros
	    private static int getIntInput(String prompt) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print(prompt);
	        while (!scanner.hasNextInt()) {
	            System.out.println("Entrada inválida. Digite um número inteiro.");
	            System.out.print(prompt);
	            scanner.next();
	        }
	        return scanner.nextInt();
	    }
	    
	    
	  //Método para visualizar agendamentos(Personal Trainer)
		public static void visualizarAgendamentos(PersonalTrainer pTrainer) {
		   boolean encontrouAgendamentos = false;
		   
		   
			for (Agendamento agendamento : agendamentos) {
		        if (agendamento.getPersonalTrainer() == pTrainer) {
		            encontrouAgendamentos = true;	          
		        }
			} 
			 if(encontrouAgendamentos == true) {
				 System.out.println("Agenda de Atendimentos com " + pTrainer.nome + "\n");
			 }
		    for (Agendamento agendamento : agendamentos) {
		        if (agendamento.getPersonalTrainer() == pTrainer) {	            
		            System.out.println("Data: " + agendamento.getDataAgendamento());
		            System.out.println("Hora: " + agendamento.getHoraAgendamento());
		            System.out.println("Aluno: " + agendamento.getAluno().getNome());
		            System.out.println("--------------------------");
		        }
		    }
		    if (!encontrouAgendamentos) {
		        System.out.println("Sua agenda está vazia!");
		    }
		}

	
	
	
	
}