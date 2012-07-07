package com.jam.productmanager.dao;

import java.sql.Connection;

import org.junit.Test;

public class DaoUtilsTest {

	@Test
	public void test() throws Exception {
		Connection conn = DaoUtils.getConn();
		if(conn == null) {
			throw new Exception("conn null");
		}
	}

}
