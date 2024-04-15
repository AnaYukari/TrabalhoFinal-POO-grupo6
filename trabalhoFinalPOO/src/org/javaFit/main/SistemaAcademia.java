package org.javaFit.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.javaFit.classes.Plano;
import org.javaFit.classes.Especialidade;
import org.javaFit.classes.Agendamento;
import org.javaFit.classes.Aluno;
import org.javaFit.classes.AvaliacaoFisica;
import org.javaFit.classes.Funcionario;
import org.javaFit.classes.PersonalTrainer;
import org.javaFit.classes.Pessoa;

public class SistemaAcademia {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pessoa> pessoasRegistradas = new ArrayList<>();
    private static List<Plano> planos = new ArrayList<>();
    private static List<PersonalTrainer> personalTrainers = new ArrayList<>();
    static List<Agendamento> agendamentos = new ArrayList<>();

    public static void main(String[] args) {
    	
    	//inclusão de funcionários iniciais do sistema
        Funcionario funcionario1 = new Funcionario("Ana Yukari", "111.222.333-44", LocalDate.of(2005, 05, 17), "yukari@sushi.com", "senha789", "Gerente");
        Funcionario funcionario2 = new Funcionario("Victor", "161.015.727-30", LocalDate.of(1992, 05, 15), "999124405", "senha777", "Atendente");
        Funcionario funcionario3 = new Funcionario("Jacqueline", "275.655.478-96", LocalDate.of(1997, 06, 16), "jacqueline@serratec.com", "senha555", "Presidente da Empresa");

        pessoasRegistradas.add(funcionario1);
        pessoasRegistradas.add(funcionario2);
        pessoasRegistradas.add(funcionario3);
        
		//início do programa
        boolean sair = false;
        while (!sair) {
            System.out.println("Academia JavaFit!\n");
            System.out.println("1. Fazer login.");
            System.out.println("2. Sair.\n");

            int opcaoInicial = getIntInput("Escolha uma opção.\n");
            
            switch (opcaoInicial) {	
            case 1:
        		System.out.println("### Login ###\n");
        	    String cpf = getInput("CPF: ");
        	    String senha = getInput("Senha: ");
        		
        	    login(cpf, senha);
                break;
            case 2:
                System.out.println("Finalizando o sistema...");
            	sair = true;
                break;        
            }	
        }
    }
		//Método para login	
	    private static void login(String cpf, String senha) {
	        for (Pessoa pessoa : pessoasRegistradas) {
	            if (cpf.equals(pessoa.getCpf()) && senha.equals(pessoa.getSenha())) {
	                if (pessoa instanceof Aluno) {
		                System.out.println("\nLogin bem-sucedido como aluno(a) " + pessoa.getNome() + ".");
			            menuAluno((Aluno) pessoa);
			        } else if (pessoa instanceof PersonalTrainer) {
		                System.out.println("\nLogin bem-sucedido como personal trainer " + pessoa.getNome() + ".");
			            menuPersonalTrainer((PersonalTrainer) pessoa);
			        } else if (pessoa instanceof Funcionario) {
		                System.out.println("\nLogin bem-sucedido como funcionário(a) " + pessoa.getNome() + ".");
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
                System.out.println("\n### Menu do Aluno ###\n");
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
                    	System.out.println("Dados pessoais:\n");
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
                    	aluno.setPersonalTrainers(personalTrainers);
                    	aluno.solicitarAgendamento();
                        break;
                    case 3:
                        //Visualizar histórico de agendamentos.
                    	aluno.visualizarHistoricoAgendamentos();
                        break;
                    case 4:
                        //Cancelar agendamento.
                    	aluno.cancelarAgendamento();
                        break;
                    case 5:
                    	break;
                    case 6:
                    	System.out.println("Log off...\n");
                    	sair = true;
                        break;
                    default:
                        System.out.println("\nOpção inválida. Tente novamente.\n");
                }
            }
    }

    //Método para login de personal trainer
    private static void menuPersonalTrainer(PersonalTrainer personalTrainer) {
            boolean sair = false;
            while (!sair) {
                System.out.println("\n### Menu do Personal Trainer ###\n");
                System.out.println("1. Visualizar agenda de atendimentos");
                System.out.println("2. Registrar avaliações físicas dos alunos");
                System.out.println("3. Visualizar lista de avaliações realizadas");
                System.out.println("4. Sair");

                int opcao = getIntInput("Escolha uma opção.");

                switch (opcao) {
                    case 1:
                        //Visualizar agenda de atendimentos.
                    	personalTrainer.visualizarAgendamentos();
                        break;
                    case 2:
                        //Registrar avaliações físicas dos alunos.
                    	System.out.println("Registrar avaliação física do aluno:");
                        String cpfAluno = getInput("CPF do aluno: ");
                        Aluno alunoParaAvaliar = null;
                        
                        for (Pessoa pessoa : pessoasRegistradas) {
                            if (pessoa instanceof Aluno && pessoa.getCpf().equals(cpfAluno)) {
                                alunoParaAvaliar = (Aluno) pessoa;
                                break;
                            }
                        }
                        if (alunoParaAvaliar == null) {
                            System.out.println("Aluno não encontrado. Verifique o CPF e tente novamente.");
                            break;
                        }
                        System.out.println("\nAvaliação do(a) aluno(a) " + alunoParaAvaliar.getNome() + "\n");                        
                        double peso = getDoubleInput("Peso (em kg): ");
                        double altura = getDoubleInput("Altura (em metro): ");
                        double imc = peso / (altura * altura);
                        double percentualGordura = getDoubleInput("Percentual de gordura corporal (%): ");
                        double massaMuscular = getDoubleInput("Massa muscular (em kg): ");
                        String observacoes = getInput("Observações: ");
                        LocalDate dataAvaliacao = LocalDate.now();
                        
                        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica(peso, altura, imc, percentualGordura, massaMuscular, observacoes, dataAvaliacao);
                        
                        alunoParaAvaliar.setAvaliacaoFisica(avaliacaoFisica);
                        
                        System.out.println("Avaliação física registrada com sucesso para o(a) aluno(a) " + alunoParaAvaliar.getNome() + "!");
                        break;
                    case 3:
                        //Visualizar lista de avaliações realizadas.
                    	visualizarAvaliacoesRealizadas();
                        break;
                    case 4:
                        sair = true;
                    	System.out.println("Log off...\n");
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
                System.out.println("\n### Menu do Funcionário ###\n");
                System.out.println("1. Cadastrar novos planos a partir de um arquivo de texto externo");
                System.out.println("2. Cadastrar novos alunos a partir de um arquivo de texto externo");
                System.out.println("3. Cadastrar novos Personal Trainers a partir de um arquivo de texto externo");
                System.out.println("4. Emitir relatório de planos");
                System.out.println("5. Emitir relatório de alunos");
                System.out.println("6. Emitir relatório de equipe (funcionários e personal trainers)");
                System.out.println("7. Emitir relação de avaliações físicas por período");
                System.out.println("8. Sair");

                int opcao = getIntInput("Escolha uma opção.");

                switch (opcao) {
                case 1:
                    //Cadastrar novo plano
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("Planos.txt"));
                        
                        while (br.ready()) {
                            String linha = br.readLine();
                            String[] partes = linha.split(";");
                            String nomePlano = partes[0];
                            double valorPlano = Double.parseDouble(partes[1]);
                            String descricaoPlano = partes[2];
                            
                            Plano novoPlano = new Plano(nomePlano, valorPlano, descricaoPlano);
                            planos.add(novoPlano);
                            System.out.println("Plano " + novoPlano.getNomePlano() + " cadastrado com sucesso!\n");
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
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("Alunos.txt"));
                        
                        while (br.ready()) {
                            String linha = br.readLine();
                            String[] partes = linha.split(";");
                            String nome = partes[0];
                            String cpf = partes[1];
                            LocalDate dataNascimento = LocalDate.parse(partes[2]);
                            String contato = partes[3];
                            String senha = partes[4];
                            String nomePlano = partes[5];
                                                      
                            Plano tipoPlano = null;
                            for (Plano plano : planos) {
                                if (plano.getNomePlano().equals(nomePlano)) {
                                    tipoPlano = plano;
                                    break;
                                }
                            }                           
                            if (tipoPlano == null) {
                                System.out.println("Plano não encontrado para o aluno(a) " + nome + ". Verifique o arquivo de planos.");
                                continue;
                            }
                            
                            int duracaoPlano = Integer.parseInt(partes[6]);
                            LocalDate dataMatricula = LocalDate.parse(partes[7]);
                            
                            Aluno aluno = new Aluno(nome, cpf, dataNascimento, contato, senha, tipoPlano, duracaoPlano, dataMatricula);
                            aluno.aplicarDesconto();
                            pessoasRegistradas.add(aluno);
                            System.out.println("Aluno(a) " + aluno.getNome() + " cadastrado(a) com sucesso!\n");
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
                				System.out.println("Personal trainer " + personalTrainer.getNome() + " cadastrado(a) com sucesso!\n");
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
                            System.out.println("Plano: " + plano.getNomePlano());
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
                    	System.out.println("Log off...\n");
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
    //Método para receber entrada de número double do usuário
    private static double getDoubleInput(String prompt) {
        double input = 0.0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }

        return input;
    }
    
    private static void visualizarAvaliacoesRealizadas() {
        System.out.println("Lista de avaliações físicas realizadas:");
        
        for (Pessoa pessoa : pessoasRegistradas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                AvaliacaoFisica avaliacaoFisica = aluno.getAvaliacaoFisica();
                
                if (avaliacaoFisica != null) {
                    System.out.println("\nAvaliação para o(a) aluno(a) " + aluno.getNome() + ":\n");
                    System.out.println("Data: " + avaliacaoFisica.getDataAvaliacao());
                    System.out.println("Peso: " + avaliacaoFisica.getPeso() + "kg");
                    System.out.println("Altura: " + avaliacaoFisica.getAltura() + "m");
                    System.out.println("IMC: " + avaliacaoFisica.getImc());
                    System.out.println("Percentual de Gordura Corporal: " + avaliacaoFisica.getPercentualGordura() + "%");
                    System.out.println("Massa Muscular: " + avaliacaoFisica.getMassaMuscular() + " kg");
                    System.out.println("Observações: " + avaliacaoFisica.getObservacoes());
                } else {
                    System.out.println("Nenhuma avaliação física registrada para o aluno " + aluno.getNome() + ".\n");
                }
            }
        }
    }
}