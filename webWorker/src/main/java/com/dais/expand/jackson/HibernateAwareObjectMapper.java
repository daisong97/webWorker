package com.dais.expand.jackson;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
/***
 * 注册 hibernate4模块
 * @author dais
 *
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
		registerModule(new Hibernate4Module());
		setSerializationInclusion(Include.NON_NULL);
	}
}
