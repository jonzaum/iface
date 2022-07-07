package menu;

import java.util.Scanner;
import chat.Send;
import command.Admin;
import comunidade.GerenciadorDeComunidade;
import main.Init;
import manage.Friends;
import manage.Profile;
import user.Usuario;

public class Menu {
		
	public Scanner input = new Scanner(System.in);
	
	public void executar(Usuario[] user, int id) {
		
		System.out.println("*** Bem-vindo(a) ao iFace, "+user[id].getNome()+" ***\n\nSelecione uma opção:\n");				
		System.out.println("1. Editar Perfil\n2. Adicionar Amigos\n3. Ver todos os amigos\n4. Enviar Mensagens");
		System.out.println("5. Criar uma comunidade");
		System.out.println("6. Vincular-se a uma comunidade\n7. Buscar Usuário");
		System.out.println("8. Ver Perfil\n9. Mostrar Conversas\n10. Deletar Conta\n0. Log Out");
		System.out.println("*********************************************");
		
		String op = input.nextLine();
		opção(op, user, id);
	}
	
	public void opção(String op, Usuario[] user, int id) {
		switch(op) {
		
			case "1":
				new Profile().executar(user[id]);
				new Menu().executar(user, id);
			case "2":
				new Friends().add(user, id);
				new Menu().executar(user, id);
			case "3":
				user[id].listarAmigos();
				System.out.println("Pressione ENTER para sair.");
				input.nextLine();
				new Menu().executar(user, id);
			case "4":
				new Send().enviarMensagem(user, id);
				new Menu().executar(user, id);
			case "5":
				new GerenciadorDeComunidade().criarComunidade(user, id);
				new Menu().executar(user, id);
			case "6":
				new GerenciadorDeComunidade().vincular(user, id);
				new Menu().executar(user, id);
			case "7":
				new Profile().search(user);
				new Menu().executar(user, id);
			case "8":
				new Profile().display(user[id]);
				new Menu().executar(user, id);
			case "9":
				new Send().mostrarConversas(user, id);
				new Menu().executar(user, id);
			case "10":
				user[id] = null;
				System.out.println("USUÁRIO DELETADO COM SUCESSO!!!\n");
				new Init().executar();
			case "0":
				new Init().executar();
			default:
				System.out.println("Entrada inválida. Tente novamente.");
				new Menu().executar(user, id);
		}
	}	
	
}
