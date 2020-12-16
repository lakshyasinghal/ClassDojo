package com.classDojo.factory.entityFactory;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import com.classDojo.entities.Teacher;
import com.classDojo.json.Json;

public class TeacherFactory implements EntityFactory<Teacher> {
	private static TeacherFactory instance;

	private TeacherFactory() {
		// nothing goes here
	}

	public static TeacherFactory instance() throws Exception {
		if (instance == null) {
			synchronized (TeacherFactory.class) {
				if (instance == null) {
					instance = new TeacherFactory();
				}
			}
		}
		return instance;
	}

	@Override
	public Teacher createFromResultSet(ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String name = rs.getString("name");
		byte age = rs.getByte("age");
		String mobile = rs.getString("mobile");
		Date created = rs.getDate("created");
		return new Teacher(id, email, password, name, age, mobile, created);
	}

	@Override
	public List<Teacher> createFromResultSet(Result<Record> result) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher createFromJson(String json) throws Exception {
		return Json.parse(json, Teacher.class);
	}

	@Override
	public List<Teacher> getListFromJson(String json) throws Exception {

		return null;
	}

}
