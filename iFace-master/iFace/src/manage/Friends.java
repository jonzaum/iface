package manage;

import java.util.Scanner;
import command.Admin;
import user.Usuario;

public class Friends {
	
	public Scanner input = new Scanner(System.in);
	
	public void add(Usuario[] user, int index) {
		if(Admin.INDEX == 1) {
			System.out.println("Não há outros usuários para adicionar como amigos.");
			return;
		}
		System.out.println("Selecione um ID para adicionar:");
		Admin.listarUsuarios();
		int id = input.nextInt();
		if(user[id] != null && id != index) {
			user[index].addAmigo(user[id].getNome());
			
		}
		
		else {
			System.out.println("Entrada Inválida. Tente novamente.");
			add(user, index);
		}
	}
}
