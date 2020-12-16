package com.classDojo.auth.service;

public interface AuthorizationService {
	
	public abstract String createAuthorizationToken();
	
	public abstract boolean validate();
}
