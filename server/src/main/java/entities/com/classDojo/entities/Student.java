package com.classDojo.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {

	public Student() {
		super();
	}

	public Student(int id, String email, String password, String name, byte age, String mobile, Date created) {
		super(id, email, password, name, age, mobile, created);
	}

	// will return a map representation of the Student object
	// will be mostly used when inserting new Student or updating existing Student
	// into database
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// putting super object fields into map
		Map<String, Object> superMap = super.map();
		map.putAll(superMap);

		return map;
	}
}
