package comunidade;

public class Comunidade {
	
	private String titulo;
	private String descricao;
	private String criador;
	private String[] membros = new String[100];
	public int index = 0;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String[] getMembros() {
		return membros;
	}
	public void addMembros(String membros) {
		this.membros[index] = membros;
		index += 1;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	}
}
