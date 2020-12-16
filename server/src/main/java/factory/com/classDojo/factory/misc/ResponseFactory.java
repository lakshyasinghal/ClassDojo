package com.classDojo.factory.misc;


import java.util.Map;
import com.classDojo.response.JsonResponse;
import com.classDojo.response.Response;

public class ResponseFactory {
	private static ResponseFactory factory = new ResponseFactory();
	
	private ResponseFactory(){
		
	}
	
	public static ResponseFactory instance(){
		return factory;
	}
	
	public Response getJsonResponse(boolean success, String message, Map<String,Object> map) throws Exception{
		JsonResponse response  = new JsonResponse(success, message, map);
		return response;
	}
}
