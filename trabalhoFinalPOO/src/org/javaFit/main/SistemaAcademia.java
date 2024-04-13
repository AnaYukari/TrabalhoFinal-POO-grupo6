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


    	
    	//inclusão pessoas inicias para teste
        Aluno aluno1 = new Aluno("Madu", "123.456.789-00", LocalDate.of(1999, 06, 19), "123456789", "senha123", planoBasico, LocalDate.now());
        PersonalTrainer personalTrainer1 = new PersonalTrainer("Nicolle", "478.655.489-54", LocalDate.of(2005, 05, 17), "987654321", "senha456", null, "123ABC", "08:00 - 12:00");
        Funcionario funcionario1 = new Funcionario("Ana Yukari", "111.222.333-44", LocalDate.of(1998, 04, 15), "111222333", "senha789", "Gerente");
        Aluno aluno2 = new Aluno("Alexandre", "728.765.446-86", LocalDate.of(1989, 11, 8), "123456789", "senha999", planoPremium, LocalDate.now());
        PersonalTrainer personalTrainer2 = new PersonalTrainer("Kayque", "987.654.321-00", LocalDate.of(2002, 9, 21), "987654321", "senha888", null, "789456", "13:00 - 17:00");
        Funcionario funcionario2 = new Funcionario("Victor", "442.478.265-98", LocalDate.of(1992, 05, 15), "111222333", "senha777", "Atendente");
        pessoasRegistradas.add(aluno1);
        pessoasRegistradas.add(aluno2);
        pessoasRegistradas.add(personalTrainer1);
        pessoasRegistradas.add(personalTrainer2);
        pessoasRegistradas.add(funcionario1);
        pessoasRegistradas.add(funcionario2);
        
		//testes de duração de plano
		planoBasico.setDuracaoPlano(25);
		planoBasico.aplicarDesconto();
	   
		//início do programa
		System.out.println("Academia Serratec!");
		System.out.println("  ### Login ###");
	    String cpf = getInput("CPF: ");
	    String senha = getInput("Senha: ");
		
	    login(cpf, senha);
    
    }		
	//Método para login	
    private static void login(String cpf, String senha) {
        for (Pessoa pessoa : pessoasRegistradas) {
            if (cpf.equals(pessoa.getCpf()) && senha.equals(pessoa.getSenha())) {
                System.out.println("Login bem-sucedido como " + pessoa.getNome() + ".");
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
//                        System.out.println("Plano Contratado: " + aluno.getNomePlano().getNomePlano());
//                        System.out.println("Duração do Plano: " + aluno.getPlano().getDuracaoPlano() + " meses");
//                        System.out.println("Valor do Plano: R$" + aluno.getPlano().getValorPlano());
//                        System.out.println("Descrição do Plano: " + aluno.getPlano().getDescricaoPlano());
                        break;
                    case 2:
                        //Solicitar agendamento de horário com personal trainer.
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
                				LocalDate dataMatricula = LocalDate.parse(partes[6]);
                				
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
                				Pessoa pessoa = new Aluno(nome, cpf, dataNascimento, contato, senha, tipoPlano, dataMatricula);
                				pessoasRegistradas.add(pessoa);

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
                        break;
                    case 4:
                        //Emtir relatório de planos
                        break;
                    case 5:
                        //Emitir relatório de alunos
                        break;
                    case 6:
                        //Emitir relatório de equipe (funcionários e personal trainers)
                        break;
                    case 7:
                        //Emitir relação de avaliações físicas por período
                        break;
                    case 8:
                    	System.out.println(pessoasRegistradas);
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
}