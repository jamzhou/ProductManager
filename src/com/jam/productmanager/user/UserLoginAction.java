/**
 * User Login Action
 */
package com.jam.productmanager.user;

import com.jam.utils.StrutsUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @autor JamZhou
 *
 * 2012-8-28 обнГ11:12:52
 */
public class UserLoginAction extends ActionSupport {
	
	public String login() {
		String username = StrutsUtils.getRequestParameter("username");
		String password = StrutsUtils.getRequestParameter("password");
		if("admin".equals(username) && "1".equals(password)) {
			return "SUCCESS";
		}
		return "FAILED";
	}
}
