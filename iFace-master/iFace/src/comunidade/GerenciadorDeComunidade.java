package comunidade;

import java.util.Scanner;
import user.Usuario;

public class GerenciadorDeComunidade {
	
	public static Comunidade[] comunidades = new Comunidade[100];
	public static int comunidadeIndex = 0;
	public int cont = 0;
	Scanner input = new Scanner(System.in);
	
	public void criarComunidade(Usuario[] user, int id) {
		comunidades[comunidadeIndex] = new Comunidade();
		
		System.out.println("****** Criando uma comunidade ******\n");
		System.out.println("Digite o título:");
		String titulo = input.nextLine();
		comunidades[comunidadeIndex].setTitulo(titulo);
		
		System.out.println("Digite a descrição da comunidade:");
		String descricao = input.nextLine();
		comunidades[comunidadeIndex].setDescricao(descricao);
		
		comunidades[comunidadeIndex].setCriador(user[id].getNome());
		user[id].comunidades[user[id].comIndex] = titulo;
		user[id].comIndex += 1;
		
		comunidadeIndex += 1;
		System.out.println("Comunidade criada com sucesso!!!\n");
	}
	
	public void vincular(Usuario[] user, int id) {
		
		cont = 0;
		
		System.out.println("*** Lista de Comunidades Disponíveis ***\n");
		listarComunidades(user[id]);
		if(cont == 0) {
			System.out.println("Não há comunidades disponiveis\n");
			return;
		}
		System.out.println("Selecione a comunidade a que deseja vincular-se:");
		int indice = input.nextInt();
		input.nextLine();
		if(comunidades[indice] != null) {
			comunidades[indice].addMembros(user[id].getNome());
			System.out.println("Adicionado à comunidade com sucesso!!!\n");
			
		}else {
			System.out.println("Entrada invalida, tente novamente!\n");
			vincular(user, id);
		}
	}
	
	public void listarComunidades (Usuario user) {
		for(int i=0; i<comunidadeIndex; i++) {
			if(!membro(user, comunidades[i]) && !comunidades[i].getCriador().equals(user.getNome())) {
				System.out.println(i+". "+comunidades[i].getTitulo());
				cont += 1;
			}
		}
	}
	
	public boolean membro(Usuario user, Comunidade comunidade) {
		for(int i=0; i<comunidade.index; i++) {
			if(user.getNome().equals(comunidade.getMembros()[i])) {
				return true;
			}
		} return false;
	}
}
