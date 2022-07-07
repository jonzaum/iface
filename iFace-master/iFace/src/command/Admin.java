package command;

import user.Usuario;

public class Admin {
	
	public static int INDEX;
	
	public static Usuario[] usuarios = new Usuario[100];
	
	public static void listarUsuarios() {
		for (int i=0; i < INDEX; i++) {
			if(usuarios[i] != null) {
				System.out.println(i+" - "+usuarios[i].getNome());
			}
		}
	}
	
	public static int buscar(String nome) {
		for(int i=0; i<INDEX; i++) {
			if(nome.equals(usuarios[i].getNome()))
				return i;
		}
		return -1;
	}
}
