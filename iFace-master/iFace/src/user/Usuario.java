package user;

import chat.Mensagem;

public class Usuario {
	
	private String login;
	private String senha;
	
	private int id;
	private String nome;
	private String genero = "não definido";
	private int idade = 0;
	private String cidade = "não definido(a)";
	private String statusDeRelacionamento = "não definido(a)";
	private String bio = "não definido(a)";
	
	public int atualINDEX = 0;
	public String[] amigos = new String[100];
	
	public int msgIndex = 0;
	private Mensagem[] mensagens = new Mensagem[100];
	
	public int comIndex = 0;
	public String[] comunidades = new String[600];
	
	public void listarAmigos() {
		System.out.println("***** Lista de Amigos *****\n");
		if(atualINDEX == 0) {
			System.out.println("Você ainda não tem amigos :(\n");
			return;
		}
		for(int i=0; i<atualINDEX; i++)
		{
			System.out.println(i+". "+amigos[i]);
		}
		System.out.println();
	}

	public void addAmigo(String amigo) {
		
		amigos[atualINDEX] = new String();
		amigos[atualINDEX] = amigo;
		atualINDEX += 1;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String endereco) {
		this.cidade = endereco;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getStatusDeRelacionamento() {
		return statusDeRelacionamento;
	}

	public void setStatusDeRelacionamento(String estadoCivil) {
		this.statusDeRelacionamento = estadoCivil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public void delete() {
		//this = null;
	}

	public int getMsgIndex() {
		return msgIndex;
	}

	public void setMsgIndex(int msgIndex) {
		this.msgIndex = msgIndex;
	}

	public Mensagem[] getMensagens() {
		return mensagens;
	}

	public void setMensagens(Mensagem mensagens) {
		this.mensagens[msgIndex] = mensagens;
		msgIndex += 1;
	}

}
