package com.dais.expand.shiro;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.realm.Realm;

import com.dais.common.app.ApplicationUtil;
import com.dais.common.app.Constants;
import com.dais.domain.User;
import com.dais.expand.exception.CaptchaException;
import com.dais.expand.exception.NotExpectException;

public class UserRealm implements Realm{

	
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		String username=(String)token.getPrincipal();
		String password=new String((char[])token.getCredentials());
		List<User> list=ApplicationUtil.getUserService().listUser(new Object[]{username});
		
		CaptchaUsernamePasswordToken captchaUsernamePasswordToken=(CaptchaUsernamePasswordToken)token;
		if(captchaUsernamePasswordToken.isCheckCaptcha()){
			if(!captchaUsernamePasswordToken.getClientCaptcha().toLowerCase()
					.equals(captchaUsernamePasswordToken.getServerCaptcha().toLowerCase())){
				throw new CaptchaException("验证码验证失效！");
			}
		}
		if(list.size() == 0){
			throw new UnknownAccountException("未找到该用户："+username); //如果用户名错误  
		}
		if(list.size()!=1){
			throw new NotExpectException("出现多余的用户。");
		}
		User user = list.get(0);
		if(StringUtils.isBlank(user.getPassword())){
			throw new IncorrectCredentialsException("错误的密码。");
		}
		if(!user.getPassword().equals(password)){
			throw new IncorrectCredentialsException("错误的密码。"); 
		}
		
		return new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),Constants.USERS_REALM);
	}

	
	public String getName() {
		return Constants.USERS_REALM;
	}

	
	public boolean supports(AuthenticationToken taken) {
		return taken instanceof CaptchaUsernamePasswordToken;
	}

}
