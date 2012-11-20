/**
 * 
 */
package com.jam.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * @autor JamZhou
 *
 * 2012-8-12 обнГ8:23:23
 */
public class StrutsUtils {

	public static String getRequestParameter(String parameterName) {
		ActionContext ct= ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ct.get(ServletActionContext. HTTP_REQUEST );
		String parameter = request.getParameter(parameterName);
		return parameter;
	}
}
