package com.dais.expand;

import java.util.Enumeration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	
	public void sessionCreated(HttpSessionEvent arg0) {
		Enumeration<String> enums=arg0.getSession().getAttributeNames();
		System.out.println("create------------start sessionTag---------------");
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			Object val=arg0.getSession().getAttribute(name);
			System.out.println(name+"--->"+val);
			
		}
		System.out.println("create------------end sessionTag---------------");
	}

	
	public void sessionDestroyed(HttpSessionEvent arg0) {
		Enumeration<String> enums=arg0.getSession().getAttributeNames();
		System.out.println("Destroyed------------start sessionTag---------------");
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			Object val=arg0.getSession().getAttribute(name);
			System.out.println(name+"--->"+val);
			
		}
		System.out.println("Destroyed------------end sessionTag---------------");
	}

}
