package com.dais.expand.exception;

/**
 * 不是期待结果。
 * @author dais
 *
 */
public class NotExpectException extends RuntimeException {
	private static final long serialVersionUID = -6985907812455020393L;
	public NotExpectException() {
	
	}
	public NotExpectException(String msg) {
		super(msg);
	}
}
