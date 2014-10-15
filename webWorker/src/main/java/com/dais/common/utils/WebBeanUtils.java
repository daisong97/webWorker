package com.dais.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WebBeanUtils implements ApplicationContextAware{
	private static String webBasePath;
	private static ApplicationContext context;

	
	public static String getWebBasePath() {
		return webBasePath;
	}

	public static void setWebBasePath(String webBasePath) {
		if(StringUtils.isBlank(getWebBasePath())){
			WebBeanUtils.webBasePath = webBasePath;
		}else{
			throw new RuntimeException("该变量为只读变量，不如需修改!");
		}
	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		WebBeanUtils.setContext(context);
	}

	public static ApplicationContext getContext() {
		return context;
	}

	private static void setContext(ApplicationContext context) {
		WebBeanUtils.context = context;
	}
	
	public static <T> T getBean(Class<T> clazz){
		return context.getBean(clazz);
	}
	
	public static Object getBean(String id){
		return context.getBean(id);
	}
}
