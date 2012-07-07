/**
 * 
 */
package com.jam.productmanager.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @autor JamZhou
 *
 * 2012-7-8 上午12:30:14
 */
public class DaoUtils {
	
	private static DaoUtils daoUtils;
	
	private static Connection conn;
	
	public static Connection getConn() {
		if(daoUtils == null) {
			daoUtils = new DaoUtils();
			daoUtils.init();
		}
		return conn;
	}

	public static void setConn(Connection conn) {
		DaoUtils.conn = conn;
	}

	private void init() {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
			String driverClassName = properties.getProperty("jdbc.driverClassName");
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("数据库连接初始化失败...");
			e.printStackTrace();
		} finally {
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
