package com.classDojo.init;

import org.apache.log4j.Logger;

import com.classDojo.jetty.GenericServer;
import com.classDojo.jetty.JettyServer;

public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		try {
			if (args.length == 0) {
				System.out.println("Please provide port number");
				return;
			}
			int port = Integer.parseInt(args[0]);
			launch(port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initialize() {
		try {
			// nothing
		} catch (Exception ex) {
			// LOGGER.error("Error in starting application", ex);
			throw ex;
		}
	}

	private static void startServer(int port) throws Exception {
		int idleTimeout = 10000; // 10 secs
		GenericServer server = new JettyServer(port, idleTimeout);
		server.start();
	}

	private static void launch(int port) throws Exception {
		System.out.println("Launching...");
		LOGGER.info("Launching...");
		initialize();
		startServer(port);
		System.out.println("SERVER LAUNCHED AT PORT " + port);
		LOGGER.info("SERVER LAUNCHED AT PORT " + port);
	}
}