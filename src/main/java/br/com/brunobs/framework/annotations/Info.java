package br.com.brunobs.framework.annotations;

import java.util.List;

import br.com.brunobs.framework.fetch.FetchType;

public class Info {

	private Integer totalRegistrosGeral;
	private FetchType fetchType;
	private Integer totalRegistroDevolvidos;
	private List<?> lista;

	public List<?> getLista() {
		return this.lista;
	}

	public void setLista(List<?> lista) {
		this.lista = lista;
	}

	public Integer getTotalRegistrosGeral() {
		return this.totalRegistrosGeral;
	}

	public void setTotalRegistrosGeral(Integer totalRegistrosGeral) {
		this.totalRegistrosGeral = totalRegistrosGeral;
	}

	public FetchType getFetchType() {
		return this.fetchType;
	}

	public void setFetchType(FetchType fetchType) {
		this.fetchType = fetchType;
	}

	public Integer getTotalRegistroDevolvidos() {
		return this.totalRegistroDevolvidos;
	}

	public void setTotalRegistroDevolvidos(Integer totalRegistroDevolvidos) {
		this.totalRegistroDevolvidos = totalRegistroDevolvidos;

	}

}
