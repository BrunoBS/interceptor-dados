package br.com.brunobs.framework.fetch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FetchService {
	private static final int LIMIT = 10000;

	public static Collection<? extends Object> execute(Collection<? extends Object> lista) throws Exception {
		return execute(lista, LIMIT);

	}

	public static Object execute(Object objeto) throws Exception {
		return execute(objeto, LIMIT);

	}

	public static Collection<? extends Object> execute(Collection<? extends Object> lista, int limit) throws Exception {
		lista = FetchFactory.setRecursoURL(lista, limit);

		return lista;

	}

	@SuppressWarnings("unchecked")
	public static Object execute(Object objeto, int limit) throws Exception {
		List<Object> list = new ArrayList<Object>();
		list.add(objeto);
		list = (List<Object>) FetchFactory.setRecursoURL(list, limit);
		return list.get(0);

	}
}
