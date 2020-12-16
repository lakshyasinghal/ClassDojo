package com.classDojo.factory.entityFactory;

import java.sql.ResultSet;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import com.classDojo.entities.Enrollment;
import com.classDojo.json.Json;

public class EnrollmentFactory implements EntityFactory<Enrollment> {
	private static EnrollmentFactory instance;

	private EnrollmentFactory() {
		// nothing goes here
	}

	public static EnrollmentFactory instance() throws Exception {
		if (instance == null) {
			synchronized (EnrollmentFactory.class) {
				if (instance == null) {
					instance = new EnrollmentFactory();
				}
			}
		}
		return instance;
	}

	@Override
	public Enrollment createFromResultSet(ResultSet rs) throws Exception {

		return null;
	}

	@Override
	public List<Enrollment> createFromResultSet(Result<Record> result) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enrollment createFromJson(String json) throws Exception {
		return Json.parse(json, Enrollment.class);
	}

	@Override
	public List<Enrollment> getListFromJson(String json) throws Exception {

		return null;
	}

}
