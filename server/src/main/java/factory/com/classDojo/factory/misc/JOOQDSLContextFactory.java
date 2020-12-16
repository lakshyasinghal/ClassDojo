package com.classDojo.factory.misc;

import java.sql.Connection;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.classDojo.connectionPool.ConnectionPoolManager;

public class JOOQDSLContextFactory {
	private static JOOQDSLContextFactory instance = new JOOQDSLContextFactory();

	private JOOQDSLContextFactory() {

	}

	public static JOOQDSLContextFactory instance() {
		return instance;
	}

	public DSLContext getDSLContext() throws Exception {
		return DSL.using(ConnectionPoolManager.getConnection(), SQLDialect.MYSQL);
	}

	public DSLContext getDSLContext(Connection con) throws Exception {
		return DSL.using(con, SQLDialect.MYSQL);
	}
}
