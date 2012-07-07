/**
 * 
 */
package com.jam.productmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ÉÏÎç1:40:49
 */
@Component("daoManager")
public class DaoManagerImpl implements DaoManager {
	
	public Connection conn = DaoUtils.getConn();
	
	public void executeSql(String sql) throws SQLException {
		Statement statement = conn.createStatement();
		statement.execute(sql);
	}
	
	public ResultSet querySql(String sql) throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery(sql);
		return rs;
	}
}

