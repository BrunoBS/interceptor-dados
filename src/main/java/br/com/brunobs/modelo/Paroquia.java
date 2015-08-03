package br.com.brunobs.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.brunobs.framework.annotations.RecursoList;

public class Paroquia {

	private Long id = 0l;
	private String nome;
	private String urlGrupos;

	@RecursoList(nomeAtributoParaURL = "urlGrupos", nomeAtributoIDPai = "id", recurso = "paroquias/{id}/grupos")
	private List<Grupo> grupos = new ArrayList<Grupo>();

	public Paroquia(String nome) {
		this.nome = nome;
	}

	public Paroquia() {
		super();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrlGrupos() {
		return this.urlGrupos;
	}

	public void setUrlGrupos(String urlGrupos) {
		this.urlGrupos = urlGrupos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void addGrupo(Grupo grupo) {
		this.grupos.add(grupo);
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}
