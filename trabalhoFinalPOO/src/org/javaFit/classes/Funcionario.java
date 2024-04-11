package org.javaFit.classes;

import java.time.LocalDate;

//subclasse de Pessoa
public class Funcionario extends Pessoa {
	private String cargo;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, String contato, String senha, String cargo) {
		super(nome, cpf, dataNascimento, contato, senha);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	//métodos
	public void menuFuncionario() {
		System.out.printf("1-Editar\n2-Sair");
	}

	@Override
	public String toString() {
		return String.format("""
				Cargo: %s
				""", cargo);
	}


}