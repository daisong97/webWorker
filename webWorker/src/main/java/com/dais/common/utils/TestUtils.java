package com.dais.common.utils;

public class TestUtils {
	private static ThreadLocal<String> local=new ThreadLocal<String>();
	public static String get(){
		return local.get();
	}
	public static void set(String value){
		local.set(value);
	}
}
