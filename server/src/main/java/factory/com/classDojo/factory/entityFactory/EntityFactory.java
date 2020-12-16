package com.classDojo.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

public interface EntityFactory<T> {

	public T createFromResultSet(ResultSet rs) throws Exception;

	public List<T> createFromResultSet(Result<Record> result) throws Exception;

	public T createFromJson(String json) throws Exception;

	public List<T> getListFromJson(String json) throws Exception;
}
