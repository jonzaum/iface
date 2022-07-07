package manage;

import java.util.Scanner;

import command.Admin;
import comunidade.Comunidade;
import comunidade.GerenciadorDeComunidade;
import menu.Menu;
import user.Usuario;

public class Profile {
	
	public Scanner input = new Scanner(System.in);
	public void executar(Usuario user) {
		
		System.out.println("Escolha a informação que deseja alterar:");
		System.out.println("1. Nome\n2. Gênero\n3. Idade\n4. Cidade\n5. Status de Relacionamento\n6. Bio\n0. Voltar");
		editInfo(user);		
	}
	
	public void search(Usuario[] user) {
		System.out.println("Insira o nome do usuário que deseja buscar:");
		String usuario = input.nextLine();
		int id = Admin.buscar(usuario);
		if(id != -1) {
			display(user[id]);
		}
		else {
			System.out.println("Usuário não encontrado\n");
			return;
		}
	}
	
	public void editInfo(Usuario user) {
		
		String info = input.nextLine();
		
		switch(info) {
		case "1":
			System.out.println("Digite o nome:");
			info = input.nextLine();
			user.setNome(info);
			System.out.println("Nome alterado com sucesso!\n");
			executar(user);
		case "2":
			System.out.println("Digite o gênero:\n1. Masculino\n2. Feminino");
			info = input.nextLine();
			user.setGenero(info);
			System.out.println("Gênero alterado com sucesso!\n");
			executar(user);
		case "3":
			System.out.println("Digite a idade:");
			info = input.nextLine();
			user.setIdade(Integer.parseInt(info));
			System.out.println("Idade alterada com sucesso!\n");
			executar(user);
		case "4":
			System.out.println("Digite a cidade:");
			info = input.nextLine();
			user.setCidade(info);
			System.out.println("Cidade alterada com sucesso!\n");
			executar(user);
		case "5":
			System.out.println("Digite o status de relacionamento:");
			info = input.nextLine();
			user.setStatusDeRelacionamento(info);
			System.out.println("Status de relacionamento alterado com sucesso!\n");
			executar(user);
		case "6":
			System.out.println("Descreva a bio:");
			info = input.nextLine();
			user.setBio(info);
			System.out.println("Bio alterada com sucesso!\n");
			executar(user);
		case "0":
			new Menu().executar(Admin.usuarios, user.getId());
		default :
			System.out.println("Entrada inválida. Digite novamente.\n");
			editInfo(user);
		}
		
	}
	
	public void display(Usuario user) {
		
		System.out.println("*** Informações de perfil ****\n");
		System.out.println("Nome: "+user.getNome());
		if(user.getIdade() > 0) {
			System.out.println("Idade: "+user.getIdade());
		}
		else if (user.getIdade() == 0){
			System.out.println("Idade: não definido(a)");
		}
		if(user.getGenero().equals("1")) {
			System.out.println("Gênero: masculino");
		}
		else if(user.getGenero().equals("2")) {
			System.out.println("Gênero: feminino");
		}
		else {
			System.out.println("Gênero: não definido(a)");
		}
		System.out.println("Cidade: "+user.getCidade());
		System.out.println("Status de Relacionamento: "+user.getStatusDeRelacionamento());
		System.out.println("Bio: "+user.getBio());
		System.out.println("Comunidades que faz parte:");
		membro(user);
		System.out.println();
		System.out.println("Pressione ENTER para sair.");
		input.nextLine();
		
	}
	
	public void membro(Usuario user) {
		int count = 0;
		int i = 0;
		
		for(i=0; i< user.comIndex; i++) {
			System.out.println(user.comunidades[i]);
			count += 1;
		}
		 if (count == 0) {
			System.out.println("não está vinculado a nenhuma comunidade.");
		}
	}
}
