package br.com.brunobs.framework.fetch;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.brunobs.framework.annotations.RecursoList;

public abstract class FetchFactory {
	private static final Logger log = LoggerFactory.getLogger(FetchFactory.class);

	public static Collection<?> setRecursoURL(Collection<?> lista, long limit) throws Exception {
		long total = getTotalRegistros(lista);
		FetchType type = FetchType.LAZY;
		log.info("TOTAL DE REGISTRO NA LISTA: " + total);
		log.info("TOTAL DE REGISTRO LIMIT: " + limit);
		for (Object object : lista) {
			for (Field field : object.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(RecursoList.class)) {
					if (total > limit) {
						Annotation annotation = field.getAnnotation(RecursoList.class);
						RecursoList recurso = (RecursoList) annotation;

						Method getList = object.getClass().getMethod(set(field.getName()), List.class);
						Method nomeAtributo = object.getClass().getMethod(set(recurso.nomeAtributoParaURL()), String.class);
						Method getID = object.getClass().getMethod(get(recurso.nomeAtributoIDPai()));
						getList.invoke(object, new List[] { null });

						Object id = getID.invoke(object);
						nomeAtributo.invoke(object, montarRecurso(id.toString(), recurso.recurso()));
						type = FetchType.LAZY;
					} else {
						type = FetchType.EAGER;
					}
				}
			}
		}
		log.info("TOTAL DE REGISTRO NA LISTA: " + type);
		return lista;

	}

	private static long getTotalRegistros(Collection lista) throws Exception {
		long total = lista.size();
		for (Object object : lista) {
			total += getTotalRegistro(object);

		}
		return total;

	}

	private static long getTotalRegistro(Object entidade) throws Exception {
		long valor = 0;
		for (Field field : entidade.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(RecursoList.class)) {

				Method mtd = entidade.getClass().getMethod(get(field.getName()));
				List<Object> a = (List<Object>) mtd.invoke(entidade);
				valor += a.size();
				for (Object objeto : a) {
					valor += getTotalRegistro(objeto);
				}
			}
		}
		return valor;

	}

	private static String get(String propriedade) {
		return m(propriedade, "get");
	}

	private static String set(String propriedade) {
		return m(propriedade, "set");
	}

	private static String m(String propriedade, String tipo) {
		StringBuffer retorno = new StringBuffer();
		retorno.append(tipo);
		retorno.append(propriedade.substring(0, 1).toUpperCase());
		retorno.append(propriedade.substring(1, propriedade.length()));
		return retorno.toString();
	}

	private static String montarRecurso(String id, String recurso) throws Exception {
		int b = recurso.indexOf("{");
		int c = recurso.indexOf("}");
		if (b == -1 || c == -1) {
			throw new Exception(recurso + "\nRecurso incorreto!");
		}
		String primeira = recurso.substring(0, b);
		String segunda = recurso.substring(++c, recurso.length());
		return primeira + id + segunda;
	}
}
