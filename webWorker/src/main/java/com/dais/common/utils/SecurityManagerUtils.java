package com.dais.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.dais.common.app.Constants;

public class SecurityManagerUtils {
	public static boolean isAdminRole(){
		Subject subject = SecurityUtils.getSubject();
		
		Object userName=subject.getPrincipal();
		if(userName instanceof String){
			if(userName!=null&&
					!StringUtils.isBlank(String.valueOf(userName))){
				if(Constants.ADMIN_NAME.equals(((String) userName).toLowerCase())){
						return true;
				}
			}
		}
		
		if(subject.hasRole(Constants.ADMIN_ROLE_NAME)){
			return true;
		}
		return false;
	}
}
