package com.classDojo.entities;

import java.util.HashMap;
import java.util.Map;

public class Subject extends Entity {
	private int teacherId;
	private String name;

	public Subject() {
		super();
	}

	public Subject(int id, int teacherId, String name) {
		super(id);
		this.teacherId = teacherId;
		this.name = name;
	}

	// will return a map representation of the Subject object
	// will be mostly used when inserting new Subject or updating
	// into database
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// putting super object fields into map
		Map<String, Object> superMap = super.map();
		map.putAll(superMap);

		map.put("teacherId", teacherId);
		map.put("name", name);
		return map;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public String getName() {
		return name;
	}
}
