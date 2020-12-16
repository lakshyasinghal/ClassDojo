package com.classDojo.requestProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.classDojo.factory.misc.ResponseFactory;

public abstract class AbstractRequestProcessor {
	private static final Logger LOGGER = Logger.getLogger(AbstractRequestProcessor.class.getName());
	protected static final ResponseFactory responseFactory = ResponseFactory.instance();

	protected static final String EXCEPTION_ERROR_MESSAGE = "SOME ERROR OCCURRED";

	protected Map<String, String> getParamsFromRequest(HttpServletRequest request) throws Exception {
		Map<String, String> paramsMap = new HashMap<String, String>();
		Enumeration<String> e = request.getParameterNames();
		String param = null;
		while (e.hasMoreElements()) {
			param = e.nextElement();
			paramsMap.put(param, request.getParameter(param));
		}
		return paramsMap;
	}

	protected String getJsonFromRequest(HttpServletRequest request) throws IOException {
		LOGGER.trace("Entered getJsonFromRequest");
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			sb.append(line + "\n");
			line = reader.readLine();
		}
		reader.close();
		String jsonStr = sb.toString();
		LOGGER.debug("Payload json => " + jsonStr);
		LOGGER.trace("Entered getJsonFromRequest");
		return jsonStr;
	}

	protected void log(Exception ex, Logger LOGGER) {
		LOGGER.error("ERROR OCCURRED", ex);
	}

	protected String errMsg() {
		return EXCEPTION_ERROR_MESSAGE;
	}
}
