package com.dais.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dais.expand.exception.CaptchaException;
import com.dais.expand.shiro.CaptchaUsernamePasswordToken;

@Controller
public class loginController extends BaseController{
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	@RequestMapping(value = "doLogin") 
	@ResponseBody
	public LoginInfo doLogin(String username, String password,String captcha,boolean rememberme,
			HttpServletRequest request,HttpServletResponse response) {
/*		//--------------------------------------->
		DefaultSecurityManager securityManager = new DefaultSecurityManager();  
		//设置authenticator  
		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();  
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());  
		securityManager.setAuthenticator(authenticator);  
		  
		
		//设置authorizer  
		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();  
		authorizer.setPermissionResolver(new WildcardPermissionResolver());  
		
		securityManager.setAuthorizer(authorizer); 
		securityManager.setRealm(new UserRealm());
		SecurityUtils.setSecurityManager(securityManager);  */
		//-------------------------------------->
		
		LoginInfo loginInfo=new LoginInfo();
		Subject subject = SecurityUtils.getSubject();
		CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		token.setClientCaptcha(captcha);
		token.setRememberMe(rememberme);
		Object sessionVal=request.getSession().getAttribute("isCaptcha");
		String isCaptcha=sessionVal==null?"false":sessionVal.toString();
		
		token.setCheckCaptcha(isCaptcha.equals("true")?true:false);//
		HttpSession s=request.getSession();
		String serverCaptcha = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		token.setServerCaptcha(serverCaptcha);
		try {
			subject.login(token);
			loginInfo.setStatus(1);
			loginInfo.setJumpUrl("home");
			loginInfo.setMsg("登录成功!");
		} catch (UnknownSessionException use) {
			subject = new Subject.Builder().buildSubject();
			subject.login(token);
			loginInfo.setStatus(1);
			loginInfo.setJumpUrl("home");
			loginInfo.setMsg("登录成功!");
		} catch (UnknownAccountException ex) {
			ex.printStackTrace();
			loginInfo.setStatus(2);
			loginInfo.setJumpUrl("login");
			loginInfo.setMsg("用户验证失败!");
		} catch (IncorrectCredentialsException ice) {
			ice.printStackTrace();
			loginInfo.setStatus(3);
			loginInfo.setJumpUrl("login");
			loginInfo.setMsg("用户密码验证失败!");
		} catch (LockedAccountException lae) {
			lae.printStackTrace();
			loginInfo.setStatus(4);
			loginInfo.setJumpUrl("login");
			loginInfo.setMsg("用户已经被锁定!");
		}  catch (CaptchaException ce) {
			ce.printStackTrace();
			loginInfo.setStatus(6);
			loginInfo.setJumpUrl("login");
			loginInfo.setMsg("验证码验证失败!");
		}catch (AuthenticationException e) {
			e.printStackTrace();
			loginInfo.setStatus(5);
			loginInfo.setJumpUrl("login");
			loginInfo.setMsg("验证失败！");
		}catch (Exception e) {
			loginInfo.setStatus(7);
			loginInfo.setJumpUrl("login");
			loginInfo.setMsg("出现位置异常!");
		}
		response.setContentType("text/html;charset=utf-8");
		if(loginInfo.getStatus()!=1){
			request.getSession().setAttribute("isCaptcha", "true");
		}
		return loginInfo;
	}
	@RequestMapping("loginOut")
	public void loginOut(HttpServletRequest request){
		try {
			Subject subject = SecurityUtils.getSubject();
			//subject.logout();
			//subject.getSession().stop();//注销Session
			/*Object sessionVal=request.getSession().getAttribute("isCaptcha");
			String isCaptcha=sessionVal==null?"false":sessionVal.toString();
			String serverCaptcha = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
			if(!isCaptcha.equals("true")){
				request.getSession().setAttribute("isCaptcha", "true");
				request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, serverCaptcha);
			}else{
				//subject.logout();
			}
*/		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("getRememberMeUserName")
	@ResponseBody
	public String getLastRememberMeName(HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("rememberMe")){
					return cookie.getValue();
				}
			}
		}
		return "";
	}
}	
