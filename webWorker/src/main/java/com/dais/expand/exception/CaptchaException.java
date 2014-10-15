package com.dais.expand.exception;

public class CaptchaException  extends RuntimeException{
	private static final long serialVersionUID = 3155743070236766069L;
	public CaptchaException() {}
	public CaptchaException(String msg) {
		super(msg);
	}
}
