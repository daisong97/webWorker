package com.dais.expand.shiro;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dais.common.app.ApplicationUtil;
import com.dais.common.app.Constants;
import com.dais.domain.User;
import com.dais.expand.exception.CaptchaException;
import com.dais.expand.exception.NotExpectException;
import com.dais.service.PermissionsService;
import com.dais.service.UserService;

public class UserRealmExtends extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionsService permissionsService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) { 
		//permissionsService.listPermissions(user);
		 String username = (String)principals.getPrimaryPrincipal();  
	     SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
	 //    authorizationInfo.setRoles(userService.findRoles(username));  
	  //   authorizationInfo.setStringPermissions(userService.findPermissions(username));  
	     authorizationInfo.setStringPermissions(permissionsService.listPermissions(username));
	    return authorizationInfo; 
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
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

}
