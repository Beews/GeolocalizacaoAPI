package com.beews.webstart.util;

import org.springframework.core.GenericTypeResolver;


public class TipoResolver<Entidade> {

	@SuppressWarnings("unchecked")
	public Class<Entidade> getTipoEntidade(Class<?> clazz) {
		return (Class<Entidade>) GenericTypeResolver.resolveTypeArgument(getClass(), clazz);
	}
}
