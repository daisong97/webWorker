package com.dais.common.app;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.dais.common.utils.WebBeanUtils;
import com.dais.freemarker.directiveModel.SearchDirectiveModel;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;

/**
 *　spring mvc 初始化完成后调用...
 * @author dais
 *
 */
public class ApplicationInitAfter implements   ApplicationListener<ContextRefreshedEvent>{

	//初始化freemarker 全局变量
	public void onApplicationEvent(ContextRefreshedEvent context) {
		FreeMarkerConfigurer configurer=(FreeMarkerConfigurer)WebBeanUtils.getBean("freemarkerConfig");
		Configuration configuration=configurer.getConfiguration();
		try {
			configuration.setSharedVariable("ctx", WebBeanUtils.getWebBasePath());
			configuration.setSharedVariable("form", new SearchDirectiveModel());
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
	}

}
