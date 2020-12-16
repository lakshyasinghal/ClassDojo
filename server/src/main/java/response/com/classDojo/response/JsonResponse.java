package com.classDojo.response;

import java.util.Map;

import org.apache.log4j.Logger;

import com.classDojo.json.Json;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonResponse implements Response {
	private static final Logger LOGGER = Logger.getLogger(JsonResponse.class.getName());
	private boolean success;
	private String msg;
	private Map<String, Object> resultMap;

	public JsonResponse() {
	}

	public JsonResponse(boolean success, String msg, Map<String, Object> resultMap) {
		this.success = success;
		this.msg = msg;
		this.resultMap = resultMap;
	}

	public String process() throws Exception {
		try {
			LOGGER.info("SERIALIZING TO JSON");
			String json = serializeAsJson();
			LOGGER.info(json);
			return json;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public String serializeAsJson() throws JsonProcessingException {
		return Json.stringify(this);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}
}
