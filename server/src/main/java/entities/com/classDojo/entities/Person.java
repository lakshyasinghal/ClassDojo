package com.classDojo.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Person extends Entity {
	protected String email;
	protected String password;
	protected String name;
	protected byte age;
	protected String mobile;
	protected Date created;

	public Person() {
		// nothing
	}

	public Person(int id, String email, String password, String name, byte age, String mobile, Date created) {
		super(id);
		this.email = email;
		this.password = password;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.created = created;
	}

	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// putting super object fields into map
		Map<String, Object> superMap = super.map();
		map.putAll(superMap);

		map.put("email", email);
		map.put("password", password);
		map.put("name", name);
		map.put("age", age);
		map.put("mobile", mobile);
		return map;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public byte getAge() {
		return age;
	}

	public String getMobile() {
		return mobile;
	}

	public Date getCreated() {
		return created;
	}
}
