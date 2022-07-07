package action;

import menu.Menu;
import java.util.Scanner;

import command.Admin;
import main.Init;
import user.Usuario;

public class Action {
	
	boolean valid = false;
	Scanner input = new Scanner(System.in);
	String user;
	
	public void signIN() {
		
		//System.out.println(Admin.INDEX);
		System.out.println("Insira seu Login:");
		
		int log = -1;
		while(log == -1) {
			user = input.nextLine();
			log = busca(user);
			if(log == -1) {
				System.out.println("Login n�o encontrado no sistema, tente novamente:" + "\n" + "CANCEL - para cancelar");
				if(user.equals("CANCEL")) {
					System.out.println("Opera��o Cancelada!");
					new Init().executar();
				}
			}
		}	
		
		System.out.println("Insira sua Senha:");
		user = input.nextLine();
		while(!user.equals(Admin.usuarios[log].getSenha())) {
			
			System.out.println("Senha incorreta, tente novamente:" + "\n" + "CANCEL - para cancelar");
			user = input.nextLine();
			if(user.equals("CANCEL")) {
				System.out.println("Opera��o Cancelada!");
				new Init().executar();
			}
		}
		
		System.out.println("LOGADO COM SUCESSO!");
		new Menu().executar(Admin.usuarios, log);
	}

	public void signUP() {
		
		Admin.usuarios[Admin.INDEX] = new Usuario();
		System.out.println("Bem vindo ao cadastro!\nInsira os dados seguintes,\nLogin:");
		
		while(!valid) {
			user = input.nextLine();
			verificar(user);
		}		
		
		Admin.usuarios[Admin.INDEX].setLogin(user);
		System.out.println("Senha:");
		Admin.usuarios[Admin.INDEX].setSenha(input.nextLine());
		
		System.out.println("Nome de exibi��o:");
		Admin.usuarios[Admin.INDEX].setNome(input.nextLine());
		
		System.out.println("Login: "+Admin.usuarios[Admin.INDEX].getLogin() + "\n" + 
		"Senha: "+Admin.usuarios[Admin.INDEX].getSenha() + "\n" + 
				"Nome de usuário: "+Admin.usuarios[Admin.INDEX].getNome() );		
		
		System.out.println("\nUSUÁRIO CADASTRADO COM SUCESSO!\n");
		
		int index = Admin.INDEX;
		Admin.usuarios[Admin.INDEX].setId(index);
		Admin.INDEX += 1;
		new Menu().executar(Admin.usuarios, index);
						
	}
	
	public void verificar(String user) {
		
		valid = true;
		for(int i = 0; i < Admin.INDEX; i++) {
			if(Admin.usuarios[i] instanceof Usuario) {
				if(Admin.usuarios[i].getLogin().equals(user)) {
					valid = false;
				}
			}
		}
		
		if(!valid) {
			System.out.println("Login j� utilizado, tente outro!");
		}
		
	}
	
	public int busca(String user) {
		
		for(int i = 0; i < Admin.INDEX; i++) {
			if(Admin.usuarios[i] instanceof Usuario) {
				if(Admin.usuarios[i].getLogin().equals(user)) {
					return i;
				}
			}
		}
		return -1;
	}
}