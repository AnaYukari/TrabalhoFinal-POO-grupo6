package org.javaFit.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.javaFit.classes.Plano;
import org.javaFit.classes.Especialidade;
import org.javaFit.classes.Aluno;
import org.javaFit.classes.Funcionario;
import org.javaFit.classes.PersonalTrainer;
import org.javaFit.classes.Pessoa;

public class SistemaAcademia {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pessoa> pessoasRegistradas = new ArrayList<>();
    private static List<Plano> planos = new ArrayList<>();
    private static List<PersonalTrainer> personalTrainers = new ArrayList<>();

    public static void main(String[] args) {

    	//inclusão de planos
		Plano planoBasico = new Plano("Básico", 74.90, "\nAcesso completo ao espaço da academia.\n"
				+ "Uso de equipamentos de cardio e musculação.\n"
				+ "Aulas em grupo regulares, como aeróbica, spinning e pilates.\n"
				+ "Acesso aos vestiários e chuveiros.\n"
				+ "Orientação inicial de um instrutor.\n"
				+ "Acompanhamento básico de progresso.");

		Plano planoPremium = new Plano("Premium", 94.90, "\nTodos os benefícios do plano básico.\n"
				+ "Acesso a aulas especiais, como ioga, treinamento funcional e dança.\n"
				+ "Sessões adicionais de treinamento personalizado.\n"
				+ "Acesso a serviços extras, como sauna, banho de vapor e piscina.\n"
				+ "Avaliação física detalhada e planejamento de metas personalizadas.\n"
				+ "Acompanhamento nutricional individualizado.");

		Plano planoFamiliar = new Plano("Familiar", 59.90,
				"\nTodos os benefícios do plano básico para todos os membros da família.\n"
						+ "Descontos especiais para famílias.\n"
						+ "Aulas em grupo para todas as idades, incluindo crianças e idosos.\n"
						+ "Acesso a programas especiais de fitness em família.");

		Plano planoCorporativo = new Plano("Corporativo", 54.90,
				"\nBenefícios do plano básico para funcionários da empresa.\n"
						+ "Descontos corporativos.\n"
						+ "Possibilidade de personalizar os serviços de acordo com as necessidades da empresa.\n"
						+ "Horários exclusivos para funcionários da empresa.\n"
						+ "Programas especiais de bem-estar e saúde ocupacional.");

		Plano planoEsportivo = new Plano("Esportivo", 39.90,
				"\nDirecionado a atletas ou entusiastas de esportes que desejam melhorar seu desempenho em sua modalidade específica.\n"
						+ "Inclui acesso a treinadores especializados em esportes específicos, como corrida, natação, basquete, tênis, entre outros.\n"
						+ "Os membros recebem treinamento personalizado, que pode incluir exercícios de força, condicionamento cardiovascular, agilidade, velocidade e coordenação.\n"
						+ "Os treinadores trabalham em estreita colaboração com os membros para desenvolver um plano de treinamento que atenda às suas necessidades e objetivos esportivos.");

		planos.add(planoBasico);
		planos.add(planoPremium);
		planos.add(planoFamiliar);
		planos.add(planoCorporativo);
		planos.add(planoEsportivo);
    	
    	//inclusão de funcionários iniciais do sistema
        Funcionario funcionario1 = new Funcionario("Ana Yukari", "111.222.333-44", LocalDate.of(1998, 04, 15), "yukari@sushi.com", "senha789", "Gerente");
        Funcionario funcionario2 = new Funcionario("Victor", "161.015.727-30", LocalDate.of(1992, 05, 15), "999124405", "senha777", "Atendente");

        pessoasRegistradas.add(funcionario1);
        pessoasRegistradas.add(funcionario2);
        
		//início do programa
        boolean sair = false;
        while (!sair) {
            System.out.println("Academia Serratec!");
            System.out.println("1. Fazer login.");
            System.out.println("2. Sair.\n");

            int opcaoInicial = getIntInput("Escolha uma opção: ");
            
            switch (opcaoInicial) {	
            case 1:
        		System.out.println("Selecione uma opção: ");
        		System.out.println("  ### Login ###");
        	    String cpf = getInput("CPF: ");
        	    String senha = getInput("Senha: ");
        		
        	    login(cpf, senha);
                break;
            case 2:
                sair = true;
                break;        
            }	
        }
    }
		//Método para login	
	    private static void login(String cpf, String senha) {
	        for (Pessoa pessoa : pessoasRegistradas) {
	            if (cpf.equals(pessoa.getCpf()) && senha.equals(pessoa.getSenha())) {
	                System.out.println("\nLogin bem-sucedido como " + pessoa.getNome() + ".");
	                if (pessoa instanceof Aluno) {
			            menuAluno((Aluno) pessoa);
			        } else if (pessoa instanceof PersonalTrainer) {
			            menuPersonalTrainer((PersonalTrainer) pessoa);
			        } else if (pessoa instanceof Funcionario) {
			            menuFuncionario((Funcionario) pessoa);
			        }
	                return;
	            }
	        }
	        System.out.println("CPF ou senha incorretos. Tente novamente.");
	    }
        private static void menuAluno(Aluno aluno) {
            boolean sair = false;
            while (!sair) {
                System.out.println("\n### Menu do Aluno ###");
                System.out.println("1. Visualizar dados pessoais e plano contratado.");
                System.out.println("2. Solicitar agendamento de horário com personal trainer.");
                System.out.println("3. Visualizar histórico de agendamentos.");
                System.out.println("4. Cancelar agendamento.");
                System.out.println("5. Visualizar avaliações físicas.");
                System.out.println("6. Sair.\n");

                int escolha = getIntInput("Escolha uma opção: ");

                switch (escolha) {
                    case 1:
                    	//Visualizar dados pessoais e plano contratado.
                    	System.out.println("Dados pessoais:");
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("CPF: " + aluno.getCpf());
                        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                        System.out.println("Contato: " + aluno.getContato() + "\n");
                        System.out.println("Plano Contratado: " + aluno.getPlanoContratado().getNomePlano());
                        System.out.println("Duração do Plano: " + aluno.getDuracaoPlano() + " meses");
                        System.out.println("Valor do Plano: R$" + aluno.getPlanoContratado().getValorPlano());
                        System.out.println("Descrição do Plano: " + aluno.getPlanoContratado().getDescricaoPlano());
                        break;
                    case 2:
                        //Solicitar agendamento de horário com personal trainer.
                    	solicitarAgendamento();
                        break;
                    case 3:
                        //Visualizar histórico de agendamentos.
                        break;
                    case 4:
                        //Cancelar agendamento.
                        break;
                    case 5:
                        //Visualizar avaliações físicas.
                        break;
                    case 6:
                    	System.out.println("Finalizando o sistema...");
                    	sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
    }

    // Método para login de personal trainer
    private static void menuPersonalTrainer(PersonalTrainer personalTrainer) {
            boolean sair = false;
            while (!sair) {
                System.out.println("\n### Menu do Personal Trainer ###");
                System.out.println("1. Visualizar agenda de atendimentos");
                System.out.println("2. Registrar avaliações físicas dos alunos");
                System.out.println("3. Visualizar lista de avaliações realizadas");
                System.out.println("4. Sair");

                int opcao = getIntInput("Escolha uma opção: ");

                switch (opcao) {
                    case 1:
                        //Visualizar agenda de atendimentos.
                        break;
                    case 2:
                        //Registrar avaliações físicas dos alunos.
                        break;
                    case 3:
                        //Visualizar lista de avaliações realizadas.
                        break;
                    case 4:
                        sair = true;
                    	System.out.println("Finalizando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            }
    }

    // Método para login de funcionário
    private static void menuFuncionario(Funcionario funcionario) {
            boolean sair = false;
            while (!sair) {
                System.out.println("\n### Menu do Funcionário ###");
                System.out.println("1. Cadastrar novo plano");
                System.out.println("2. Cadastrar novo aluno a partir de um arquivo .txt externo");
                System.out.println("3. Cadastrar novo Personal Trainer a partir de um arquivo .txt externo");
                System.out.println("4. Emitir relatório de planos");
                System.out.println("5. Emitir relatório de alunos");
                System.out.println("6. Emitir relatório de equipe (funcionários e personal trainers)");
                System.out.println("7. Emitir relação de avaliações físicas por período");
                System.out.println("8. Sair");

                int opcao = getIntInput("Escolha uma opção: ");

                switch (opcao) {
                    case 1:
                        //Cadastrar novo plano
                    	try {
                			BufferedReader br = new BufferedReader(new FileReader("Planos.txt"));
                			
                			while(br.ready()) {
                				String linha = br.readLine();
                				String[] partes = linha.split(";");
                				String nome = partes[0];
                				double valor = Integer.parseInt(partes[1]);
                				String descricao = partes[2];
                				
                				Plano plano = new Plano(nome, valor, descricao);
                				planos.add(plano);
                			}
                			br.close();
                		} catch (FileNotFoundException e) {
                			System.out.println("Erro original: " + e.getMessage());
                		} catch (IOException e) {
                			System.out.println("Erro lendo o arquivo: " + e.getMessage());
                		}
                        break;
                    case 2:
                        //Cadastrar novo aluno
                    	Plano tipoPlano;
                    	try {
                			BufferedReader br = new BufferedReader(new FileReader("Alunos.txt"));
                			
                			while(br.ready()) {
                				String linha = br.readLine();
                				String[] partes = linha.split(";");
                				String nome = partes[0];
                				String cpf = partes[1];
                				LocalDate dataNascimento = LocalDate.parse(partes[2]);
                				String contato = partes[3];
                				String senha = partes[4];
                				String tipoPlanoString = partes[5];
                				int duracaoPlano = Integer.parseInt(partes[6]);
                				LocalDate dataMatricula = LocalDate.parse(partes[7]);
                				
                				if (tipoPlanoString.equals("planoBasico")) {
                				    tipoPlano = new Plano("Básico", 74.90, "\nAcesso completo ao espaço da academia.\n"
                							+ "Uso de equipamentos de cardio e musculação.\n"
                							+ "Aulas em grupo regulares, como aeróbica, spinning e pilates.\n"
                							+ "Acesso aos vestiários e chuveiros.\n"
                							+ "Orientação inicial de um instrutor.\n"
                							+ "Acompanhamento básico de progresso.");
                				} else if (tipoPlanoString.equals("planoPremium")) {
                				    tipoPlano = new Plano("Premium", 94.90, "\nTodos os benefícios do plano básico.\n"
                							+ "Acesso a aulas especiais, como ioga, treinamento funcional e dança.\n"
                							+ "Sessões adicionais de treinamento personalizado.\n"
                							+ "Acesso a serviços extras, como sauna, banho de vapor e piscina.\n"
                							+ "Avaliação física detalhada e planejamento de metas personalizadas.\n"
                							+ "Acompanhamento nutricional individualizado.");
                				} else if (tipoPlanoString.equals("planoFamiliar")) {
                				    tipoPlano = new Plano("Familiar", 59.90,
                							"\nTodos os benefícios do plano básico para todos os membros da família.\n"
                									+ "Descontos especiais para famílias.\n"
                									+ "Aulas em grupo para todas as idades, incluindo crianças e idosos.\n"
                									+ "Acesso a programas especiais de fitness em família.");
                				} else if (tipoPlanoString.equals("planoCorporativo")) {
                				    tipoPlano = new Plano("Corporativo", 54.90,
                							"\nBenefícios do plano básico para funcionários da empresa.\n"
                									+ "Descontos corporativos.\n"
                									+ "Possibilidade de personalizar os serviços de acordo com as necessidades da empresa.\n"
                									+ "Horários exclusivos para funcionários da empresa.\n"
                									+ "Programas especiais de bem-estar e saúde ocupacional.");
                				} else if (tipoPlanoString.equals("planoEsportivo")) {
                				    tipoPlano = new Plano("Esportivo", 39.90,
                							"\nDirecionado a atletas ou entusiastas de esportes que desejam melhorar seu desempenho em sua modalidade específica.\n"
                									+ "Inclui acesso a treinadores especializados em esportes específicos, como corrida, natação, basquete, tênis, entre outros.\n"
                									+ "Os membros recebem treinamento personalizado, que pode incluir exercícios de força, condicionamento cardiovascular, agilidade, velocidade e coordenação.\n"
                									+ "Os treinadores trabalham em estreita colaboração com os membros para desenvolver um plano de treinamento que atenda às suas necessidades e objetivos esportivos.");
                				} else {
                				    System.out.println("Erro nas informações do arquivo. (Plano não encontrado)");
                				    return;
                				}
                				Aluno aluno = new Aluno(nome, cpf, dataNascimento, contato, senha, tipoPlano, duracaoPlano, dataMatricula);
                				aluno.aplicarDesconto();
                				pessoasRegistradas.add(aluno);
                			}
                			br.close();
                		} catch (FileNotFoundException e) {
                			System.out.println("Erro original: " + e.getMessage());
                		} catch (IOException e) {
                			System.out.println("Erro lendo o arquivo: " + e.getMessage());
                		}
                        break;
                    case 3:
                        //Cadastrar novo Personal Trainer
                    	try {
                			BufferedReader br = new BufferedReader(new FileReader("Personal Trainers.txt"));
                			
                			while(br.ready()) {
                				String linha = br.readLine();
                				String[] partes = linha.split(";");
                				String nome = partes[0];
                				String cpf = partes[1];
                				LocalDate dataNascimento = LocalDate.parse(partes[2]);
                				String contato = partes[3];
                				String senha = partes[4];
                				String especialidadeString = partes[5];
                				Especialidade especialidade = null;
                				for (Especialidade esp : Especialidade.values()) {
                				    if (esp.name().equalsIgnoreCase(especialidadeString)) {
                				        especialidade = esp;
                				        break;
                				    }
                				}
                				String cref = partes[6];
                				String horarioAtendimento = partes[7];
                				
                				PersonalTrainer personalTrainer = new PersonalTrainer(nome, cpf, dataNascimento, contato, senha, especialidade, cref, horarioAtendimento);
                				pessoasRegistradas.add(personalTrainer);
                				personalTrainers.add(personalTrainer);
                			}
                			br.close();
                		} catch (FileNotFoundException e) {
                			System.out.println("Erro original: " + e.getMessage());
                		} catch (IOException e) {
                			System.out.println("Erro lendo o arquivo: " + e.getMessage());
                		}
                        break;
                    case 4:
                        //Emtir relatório de planos
                    	System.out.println("### Relatório de Planos ###");
                        for (Plano plano : planos) {
                            System.out.println("Nome: " + plano.getNomePlano());
                            System.out.println("Valor: R$" + plano.getValorPlano());
                            System.out.println("Descrição: " + plano.getDescricaoPlano());
                            System.out.println("===============================================");
                        }                   
                        break;
                    case 5:
                        //Emitir relatório de alunos
                    	for (Pessoa pessoa : pessoasRegistradas) {
                    	    if (pessoa instanceof Aluno) {
                    	        Aluno aluno = (Aluno) pessoa;
                    	        System.out.println("Nome: " + aluno.getNome());
                    	        System.out.println("CPF: " + aluno.getCpf());
                    	        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                    	        System.out.println("Contato: " + aluno.getContato());
                    	        System.out.println("Plano: " + aluno.getPlanoContratado());
                    	        System.out.println("Duração do plano: " + aluno.getDuracaoPlano() + " meses");
                    	        System.out.println("Data de Matrícula: " + aluno.getDataMatricula());
                    	        System.out.println("===============================================");
                    	    }
                    	}
                        break;
                    case 6:
                        //Emitir relatório de equipe (funcionários e personal trainers)
                    	for (Pessoa pessoa : pessoasRegistradas) {
                    	    if (pessoa instanceof Funcionario) {
                    	        Funcionario funcionario1 = (Funcionario) pessoa;
                    	        System.out.println("Nome: " + funcionario1.getNome());
                    	        System.out.println("CPF: " + funcionario1.getCpf());
                    	        System.out.println("Data de Nascimento: " + funcionario1.getDataNascimento());
                    	        System.out.println("Contato: " + funcionario1.getContato());
                    	        System.out.println("Cargo: " + funcionario1.getCargo());
                    	        System.out.println("===============================================");
                    	    }
                    	}
                    	for (Pessoa pessoa : pessoasRegistradas) {
                    	    if (pessoa instanceof PersonalTrainer) {
                    	        PersonalTrainer personalTrainer = (PersonalTrainer) pessoa;
                    	        System.out.println("Nome: " + personalTrainer.getNome());
                    	        System.out.println("CPF: " + personalTrainer.getCpf());
                    	        System.out.println("Data de Nascimento: " + personalTrainer.getDataNascimento());
                    	        System.out.println("Contato: " + personalTrainer.getContato());
                    	        System.out.println("Especialidade: " + personalTrainer.getEspecialidade());
                    	        System.out.println("CREF: " + personalTrainer.getCref());
                    	        System.out.println("Horário de Atendimento: " + personalTrainer.getHorarioAtendimento());
                    	        System.out.println("===============================================");
                    	    }
                    	}
                        break;
                    case 7:
                        //Emitir relação de avaliações físicas por período
                        break;
                    case 8:                    	
                    	sair = true;
                    	System.out.println("Finalizando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            }
    }

    //Método para receber entrada de texto do usuário
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    //Método para receber entrada de número inteiro do usuário
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
            }
        }
	
    }
    //!!!!!!!!!!!!!!! Precisamos adicionar disponibilidade de horários !!!!!!!!!!!!!!!
    private static void solicitarAgendamento() {
        System.out.println("### Solicitar Agendamento com Personal Trainer ###");
        System.out.println("Personal Trainers Disponíveis:");
        for (int i = 0; i < personalTrainers.size(); i++) {
            PersonalTrainer personalTrainer = personalTrainers.get(i);
            System.out.println((i + 1) + ". " + personalTrainer.getNome() + " - " + personalTrainer.getEspecialidade());
        }

        int escolha;
        do {
            escolha = getIntInput("Escolha um personal trainer: ");
        } while (escolha < 1 || escolha > personalTrainers.size());

        PersonalTrainer personalTrainerEscolhido = personalTrainers.get(escolha - 1);
        System.out.println("Você selecionou o personal trainer " + personalTrainerEscolhido.getNome() +
                           " (" + personalTrainerEscolhido.getEspecialidade() + ").");

    }
}