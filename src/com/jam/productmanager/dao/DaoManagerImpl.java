/**
 * 
 */
package com.jam.productmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ÉÏÎç1:40:49
 */
@Component("daoManager")
public class DaoManagerImpl implements DaoManager {
	
	public void executeSql(String sql) throws SQLException {
		Connection conn = DaoUtils.getConn();
		Statement statement = conn.createStatement();
		try {
			statement.execute(sql);
		} finally {
			statement.close();
			conn.close();
		}
	}
	
	public Map<String,Object> querySql(String sql) throws SQLException {
		Map<String,Object> map = new HashMap<String,Object>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection conn = DaoUtils.getConn();
		preparedStatement = conn.prepareStatement(sql);
		rs = preparedStatement.executeQuery(sql);
		map.put(KEY_CONNECTION, conn);
		map.put(KEY_PREPAREDSTATEMENT, preparedStatement);
		map.put(KEY_RESULTSET, rs);
		return map;
	}
	
}

