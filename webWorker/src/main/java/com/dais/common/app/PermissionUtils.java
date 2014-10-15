package com.dais.common.app;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;

public class PermissionUtils {
	public static void checkPermission(){
		//SecurityUtils.getSubject().login(arg0);
		Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:shiro.ini");
		
		// new IniSecurityManagerFactory(
		Ini ini=new Ini();
		//ini.put("", value)
		
		
		
	}
}
