package com.dais.common.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import com.dais.common.utils.WebBeanUtils;

/**
 * 应用开始初始化。
 * @author dais
 *
 */
public class ApplicationInitializer implements WebApplicationInitializer {
	
	public void onStartup(ServletContext context) throws ServletException {
		WebBeanUtils.setWebBasePath(context.getContextPath());
	}
	

}
