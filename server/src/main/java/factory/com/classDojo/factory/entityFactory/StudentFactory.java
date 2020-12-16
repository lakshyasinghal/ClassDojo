package com.classDojo.factory.entityFactory;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import com.classDojo.entities.Student;
import com.classDojo.json.Json;

public class StudentFactory implements EntityFactory<Student> {
	private static StudentFactory instance;

	private StudentFactory() {
		// nothing goes here
	}

	public static StudentFactory instance() throws Exception {
		if (instance == null) {
			synchronized (StudentFactory.class) {
				if (instance == null) {
					instance = new StudentFactory();
				}
			}
		}
		return instance;
	}

	@Override
	public Student createFromResultSet(ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		String email = rs.getString("email");
		String password = rs.getString("password");
		String name = rs.getString("name");
		byte age = rs.getByte("age");
		String mobile = rs.getString("mobile");
		Date created = rs.getDate("created");
		return new Student(id, email, password, name, age, mobile, created);
	}

	@Override
	public List<Student> createFromResultSet(Result<Record> result) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student createFromJson(String json) throws Exception {
		return Json.parse(json, Student.class);
	}

	@Override
	public List<Student> getListFromJson(String json) throws Exception {

		return null;
	}

}
