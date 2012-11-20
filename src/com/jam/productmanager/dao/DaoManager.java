/**
 * 
 */
package com.jam.productmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @autor JamZhou
 *
 * 2012-6-23 ионГ1:40:23
 */
public interface DaoManager {
	
	public static String KEY_PREPAREDSTATEMENT = "PreparedStatement";
	public static String KEY_RESULTSET = "Resultset";
	public static String KEY_CONNECTION = "Connection";

	public void executeSql(String sql) throws SQLException;
	
	public Map<String,Object> querySql(String sql) throws SQLException;
}
