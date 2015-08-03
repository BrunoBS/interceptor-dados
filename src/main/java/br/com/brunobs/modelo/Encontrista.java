package br.com.brunobs.modelo;


public class Encontrista {
	private long id = 0l;
	private String nome;
	private String email;

	public Encontrista(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Encontrista() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
