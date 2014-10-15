package com.dais.expand.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CaptchaUsernamePasswordToken extends UsernamePasswordToken{
	private static final long serialVersionUID = -3217596468830869181L;
	private String serverCaptcha;
	private String clientCaptcha;
	private boolean isCheckCaptcha;
	
	public String getServerCaptcha() {
		return serverCaptcha;
	}

	public void setServerCaptcha(String serverCaptcha) {
		this.serverCaptcha = serverCaptcha;
	}

	public String getClientCaptcha() {
		return clientCaptcha;
	}

	public void setClientCaptcha(String clientCaptcha) {
		this.clientCaptcha = clientCaptcha;
	}
	
	public boolean isCheckCaptcha() {
		return isCheckCaptcha;
	}

	public void setCheckCaptcha(boolean isCheckCaptcha) {
		this.isCheckCaptcha = isCheckCaptcha;
	}

	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe,
			String host,String serverCaptcha,String clientCaptcha){
		super(username, password, rememberMe, host);
		this.serverCaptcha = serverCaptcha;
		this.clientCaptcha = clientCaptcha;
	}

	public CaptchaUsernamePasswordToken(){
		super();
	}
}
