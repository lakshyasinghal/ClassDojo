package com.classDojo.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnectionPool implements ConnectionPool {
	private String host;
	private String port;
	private String dbName;
	private String username;
	private String password;
	private HikariDataSource ds;

	public HikariConnectionPool() {
	}

	public HikariConnectionPool(String host, String port, String dbName, String username, String password) {
		super();
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.username = username;
		this.password = password;
		initialize();
	}

	public void initialize() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url());
		config.setUsername(username);
		config.setPassword(password);
		ds = new HikariDataSource(config);
	}

	@Override
	public Connection getSqlConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void releaseSqlConnection(Connection conn) throws Exception {
		// do nothing
	}

	private String url() {
		return "jdbc:mysql://" + host + ":" + port + "/" + dbName;
	}

	// Close the datasource
	public void close() {
		if (ds != null) {
			ds.close();
		}
	}

}
