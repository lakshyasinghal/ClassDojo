package com.classDojo.dao.generic;

import java.sql.SQLException;

import com.classDojo.entities.Entity;

public interface Dao<T extends Entity> {
	
	public boolean create(T t) throws SQLException, Exception;
	
	public T getById(int id);
}
