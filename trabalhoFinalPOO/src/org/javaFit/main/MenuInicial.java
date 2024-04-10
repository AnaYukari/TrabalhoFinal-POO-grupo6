package org.javaFit.main;

import java.util.List;
import java.util.Scanner;

import org.javaFit.classes.Usuarios;
public class MenuInicial {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		String login;
		String senha;
		

		System.out.println("Login: ");
			leitura.nextLong();
			

			Usuarios.buscarUsuarios();
			
		
	System.out.println("Senha: ");
			leitura.nextLong();
			
	leitura.close();
	}

}
