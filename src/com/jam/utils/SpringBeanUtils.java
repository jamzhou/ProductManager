/**
 * 
 */
package com.jam.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @autor JamZhou
 *
 * 2012-7-31 обнГ10:14:11
 */
public class SpringBeanUtils {

	static WebApplicationContext wac;
	public static void init() {
		wac = ContextLoader.getCurrentWebApplicationContext();
	}
	
	public static Object getBeanByName(String beanName) {
		if(wac == null) {
			init();
		}
		return wac.getBean(beanName);
	}
}
