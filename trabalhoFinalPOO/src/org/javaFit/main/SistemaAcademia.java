package org.javaFit.main;

import java.time.LocalDate;
import java.util.Scanner;

import org.javaFit.classes.Aluno;
import org.javaFit.classes.AvaliacaoFisica;
import org.javaFit.classes.Funcionario;
import org.javaFit.classes.Menu;
import org.javaFit.classes.MetodosUteis;
import org.javaFit.classes.PersonalTrainer;
import org.javaFit.classes.Pessoa;
import org.javaFit.classes.Plano;

public class SistemaAcademia {
	//static MetodosUteis limpa;

	public static void main(String[] args) {
		Aluno menuAluno;
		PersonalTrainer menuPersonalTrainer;
		Funcionario menuFuncionario;
		Scanner leitura = new Scanner(System.in);
		Menu menus = new Menu();

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

		// testes de print
		planoBasico.setDuracaoPlano(25);
		planoBasico.aplicarDesconto();
		//System.out.println(planoBasico);

		//inclusão de pessoas
		Pessoa pessoa1 = new Aluno("Victor", "12345678911", LocalDate.of(1992, 05, 15), "22999124405", "123456", planoBasico, LocalDate.of(2024, 04, 11));
		
		Aluno aluno1 = new Aluno ("Ana Yukari", "143.543.654-43", LocalDate.of(2005, 05, 17), "ana@gmail.com", "Ana123", planoBasico, LocalDate.now());
		
		
		menus.menuInicial();
		
		menus.menuPersonalTrainer(pessoa1, aluno1);
		
		menus.menuFuncionario();
		
		menus.menuAluno();
		
  	}
}