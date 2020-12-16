package com.classDojo.connectionPool;

import java.sql.Connection;

public interface ConnectionPool {

	public Connection getSqlConnection() throws Exception;

	public void releaseSqlConnection(Connection conn) throws Exception;
}
