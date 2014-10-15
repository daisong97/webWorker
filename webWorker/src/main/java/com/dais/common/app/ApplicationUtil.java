package com.dais.common.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.dais.service.UserService;

/**
 * Bean 工具其实是个Service
 * @author dais
 *
 */
@Service
@Lazy(value=false)
public class ApplicationUtil {
	private static ApplicationContext applicationContext;
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationUtil.applicationContext=applicationContext;
	}
	/**
	 * 获取service
	 * @param serviceName
	 * @param clazz
	 * @return
	 */
	public static <T> T getService(String serviceName,Class<T> clazz){
		return applicationContext.getBean(serviceName, clazz);
	}
	/**
	 * 获取service
	 * @param serviceName
	 * @return
	 */
	public static Object getService(String serviceName){
		return applicationContext.getBean(serviceName);
	}
	/**
	 * 获取用户的service
	 * @return
	 */
	public static UserService getUserService(){
		return getService("userService", UserService.class);
	}
	
}
