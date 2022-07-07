package chat;

import java.util.Scanner;
import command.Admin;
import user.Usuario;

public class Send {
	
	public Scanner input = new Scanner(System.in);
	
	public void enviarMensagem(Usuario[] user, int id) {
		System.out.println("Selecione um amigo para enviar uma mensagem:");
		user[id].listarAmigos();
		if(user[id].atualINDEX == 0) return;
		int busca = input.nextInt();
		
		int systemID = buscar(user, busca, id);
		if(systemID == -1) {
			System.out.println("Entrada inválida. Tente novamente.");
			enviarMensagem(user, id);
		}
		else {
			System.out.println("Digite a mensagem:");
			input.nextLine();
			String msg = input.nextLine();
			
			user[id].getMensagens()[user[id].getMsgIndex()] = new Mensagem();
			user[id].getMensagens()[user[id].getMsgIndex()].setTexto(msg);
			user[id].getMensagens()[user[id].getMsgIndex()].setDestinatario(user[systemID].getNome());
			user[id].getMensagens()[user[id].getMsgIndex()].setRemetente(user[id].getNome());
			
			user[systemID].getMensagens()[user[systemID].getMsgIndex()] = new Mensagem();
			user[systemID].getMensagens()[user[systemID].getMsgIndex()].setTexto(msg);
			user[systemID].getMensagens()[user[systemID].getMsgIndex()].setDestinatario(user[systemID].getNome());
			user[systemID].getMensagens()[user[systemID].getMsgIndex()].setRemetente(user[id].getNome());
			
			user[id].msgIndex += 1;
			user[systemID].msgIndex += 1;
			
			System.out.println("Mensagem enviada para "+user[systemID].getNome()+"\n");
		}
	}
	
	public int buscar (Usuario[] user, int busca, int index)
	{
		for(int i=0; i < user[index].atualINDEX; i++) {
			if(Admin.usuarios[i].getNome().equals(user[index].amigos[busca])) {
				return i;
			}
		} return -1;
	}
	
	public void mostrarConversas(Usuario[] user, int id) {
		if(user[id].msgIndex == 0) {
			System.out.println("A caixa de mensagens está vazia.\n");
			return;
		}
		System.out.println("-----------------------------------------------------");
		for (int i=0; i<user[id].msgIndex;i++) {
	
			System.out.println("De: "+ user[id].getMensagens()[i].getRemetente());
			System.out.println("Para: "+ user[id].getMensagens()[i].getDestinatario());
			System.out.println("Mensagem:\n"+ user[id].getMensagens()[i].getTexto());
			System.out.println("-----------------------------------------------------");
		}
	}
}
