package main;

import java.util.Scanner;

import action.Action;

public class Init {
	
	Scanner input = new Scanner(System.in);
	
	public void executar() {
		
		System.out.println("******      Bem-vindo ao iFace!     ******\n");
		System.out.println("Escolha uma opção:");
		System.out.println("1. Efetuar Login\n2. Realizar cadastro\n0. Sair");
		System.out.println("******************************************");
		
		String action = input.nextLine();
		
		switch(action) {
		case "1":
			new Action().signIN();
			break;
		case "2":
			new Action().signUP();
			break;
		case "0":
			System.exit(0);
		default:
			System.out.println("Entrada incorreta!");
			executar();
		}
		
	}

}
