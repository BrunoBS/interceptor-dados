package br.com.brunobs.framework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RecursoList {
	/***
	 * atributoParaURL: Informar o nome do atributo para retornar a url caso o
	 * lista seja LAZY
	 */
	public String nomeAtributoParaURL();

	/***
	 * nomeAtributodoIDPai: Informar o nome do atributo para retornar a ID da
	 * Entidade Pai.
	 */
	public String nomeAtributoIDPai();

	/***
	 * URL para identificar o Recurso (Lista de objetos Filhos)
	 */
	public String recurso();

}