package com.dais.common.utils;

import java.lang.reflect.ParameterizedType;

public class ReflectUtils {
	private ReflectUtils(){}

	public static Class<?> getGenericSuperFormClass(
			Class<?> clazz) {
		ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
		Class<?> entity = (Class<?>)pt.getActualTypeArguments()[0];
		return entity;
	}

}
