package com.classDojo.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Json {
	private static ObjectMapper objectMapper = getDefaultObjectMapper();

	public static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultObjectMapper;
	}

	public static JsonNode parse(String src) throws JsonProcessingException, IOException {
		return objectMapper.readTree(src);
	}

	public static <A> A parse(JsonNode node, Class<A> clazz) throws JsonProcessingException {
		return objectMapper.treeToValue(node, clazz);
	}

	public static <A> A parse(String src, Class<A> clazz) throws JsonProcessingException, IOException {
		JsonNode node = objectMapper.readTree(src);
		return objectMapper.treeToValue(node, clazz);
	}

	public static String stringify(Object obj) throws JsonProcessingException {
		JsonNode node = objectMapper.valueToTree(obj);
		ObjectWriter objectWriter = objectMapper.writer();
		return objectWriter.writeValueAsString(node);
	}
}
