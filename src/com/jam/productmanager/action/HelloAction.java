/**
 * 
 */
package com.jam.productmanager.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @autor JamZhou
 *
 * 2012-7-2 обнГ11:59:54
 */
public class HelloAction extends ActionSupport {

	public String sayHello() {
		System.out.println("fuck");
		return "SUCCESS";
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Hello");
		return "SUCCESS";
	}
	
}
