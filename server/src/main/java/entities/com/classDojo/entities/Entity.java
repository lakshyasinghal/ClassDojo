package com.classDojo.entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Entity {
	protected int id = -1; // default value

	public Entity() {
		// nothing
	}

	public Entity(int id) {
		super();
		this.id = id;
	}

	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", id);
		return map;
	}

	public int getId() {
		return id;
	}

}
