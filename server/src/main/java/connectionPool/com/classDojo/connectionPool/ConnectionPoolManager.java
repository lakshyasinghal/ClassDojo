package com.classDojo.connectionPool;

import java.sql.Connection;

public class ConnectionPoolManager {
	private static ConnectionPool connectionPool = null;

	static {
		connectionPool = new HikariConnectionPool("localhost", "3306", "ClassDojo", "root", "root");
	}

	public static Connection getConnection() throws Exception {
		return connectionPool.getSqlConnection();
	}

	public static void releaseConnection(Connection conn) throws Exception {
		connectionPool.releaseSqlConnection(conn);
	}
}