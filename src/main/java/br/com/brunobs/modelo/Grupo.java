package br.com.brunobs.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.brunobs.framework.annotations.RecursoList;

public class Grupo {

	private static long id = 0;

	private String nome;

	private String urlEncontristas;

	@RecursoList(nomeAtributoParaURL = "urlEncontristas", nomeAtributoIDPai = "id", recurso = "grupos/{id}/encontristas")
	private List<Encontrista> encontristas = new ArrayList<Encontrista>();

	public Grupo(String nome) {
		++Grupo.id;
		this.nome = nome;
	}

	public String getUrlEncontristas() {
		return this.urlEncontristas;
	}

	public void setUrlEncontristas(String urlEncontristas) {
		this.urlEncontristas = urlEncontristas;
	}

	public static void setId(long id) {
		Grupo.id = id;
	}

	public void setEncontristas(List<Encontrista> encontristas) {
		this.encontristas = encontristas;
	}

	public Grupo() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getId() {
		return id;
	}

	public List<Encontrista> getEncontristas() {
		return Collections.unmodifiableList(this.encontristas);
	}

	public void addEncontrista(Encontrista encontrista) {
		this.encontristas.add(encontrista);
	}

}
