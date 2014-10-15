package com.dais.controller;

public class LoginInfo {
	String msg;//消息
	Integer status;//状态 1、登录成功，2、账户失效。3、密码失效，4、用户锁定，5、验证异常，6、其他异常。
	String jumpUrl;//跳转的Url
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getJumpUrl() {
		return jumpUrl;
	}
	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}
	
}
