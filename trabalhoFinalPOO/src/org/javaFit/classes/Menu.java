package org.javaFit.classes;

import java.util.Scanner;

public class Menu {
//	Cadastros pessoaCadastrada = new Cadastros();
	Scanner leitura = new Scanner(System.in);
	
	//Menu Inicial
	public void menuInicial() {
		String login;
		String senha;
		
		System.out.println("Login(CPF): ");
		login = leitura.nextLine();
		
	//	if (login == pessoaCadastrada.List<Pessoa>(1))
		
		System.out.println("Senha: ");
		senha = leitura.nextLine();
		
	}
		
	//Menu pro PersonalTrainer
	public void menuPersonalTrainer(Pessoa pessoa, Aluno aluno){
		int opcao;
		
		System.out.println("1- Visualizar agenda de atendimentos\n2- Registrar avaliações físicas dos alunos\n3- Visualizar lista de avaliações realizadas");
		opcao = leitura.nextInt();
		
		switch(opcao) {

		case 1:
			//1. Visualizar agenda de atendimentos.
		break;
		
		case 2:
			//2. Registrar avaliações físicas dos alunos.
			AvaliacaoFisica avaliacao;
			AvaliacaoFisica avaliacaoF1 = new AvaliacaoFisica(1.71 , 69.5);
			aluno.setAvaliacaoFisica(avaliacaoF1);
			System.out.println(aluno);
		break;
		
		case 3:
			//3. Visualizar lista de avaliações realizadas.
		break;
		}
	}
	//Menu pro Funcionário
	public void menuFuncionario(){

		System.out.println("");
		int opcaoFuncionario;
		opcaoFuncionario = leitura.nextInt();
		
		while (opcaoFuncionario < 1 || opcaoFuncionario > 7) {
			System.out.println("Digite uma opção correta.");
			opcaoFuncionario = leitura.nextInt();
			//limpa.clearConsole();
		
				switch(opcaoFuncionario) {
	
				case 1:
					//1. Cadastrar novo plano
				break;
				
				case 2:
					//2. Cadastrar novo aluno
				break;
				
				case 3:
					//3. Cadastrar novo Personal Trainer
				break;
				
				case 4:
					//4. Emtir relatório de planos
				break;
				
				case 5:
					//5. Emitir relatório de alunos
				break;
				
				case 6:
					//6. Emitir relatório de equipe (funcionários e personal trainers)
				break;
				
				case 7:
					//7. Emitir relação de avaliações físicas por período
				break;
			}
		}
		
	}
	
	//Menu pro Aluno
	public void menuAluno(){
		System.out.println("");
		int opcaoAluno;
		opcaoAluno = leitura.nextInt();
		
		while (opcaoAluno < 1 || opcaoAluno > 5) {
			System.out.println("Digite uma opção correta.");
			opcaoAluno = leitura.nextInt();
			//limpa.clearConsole();
		
				switch(opcaoAluno) {
	
				case 1:
					//1. Visualizar dados pessoais e plano contratado.
				break;
				
				case 2:
					//2. Solicitar agendamento de horário com personal trainer.
				break;
				
				case 3:
					//3. Visualizar histórico de agendamentos.
				break;
				
				case 4:
					//4. Cancelar agendamento.
				break;
				
				case 5:
					//5. Visualizar avaliações físicas.
				break;
				}		
		}
		
	}
	
}
