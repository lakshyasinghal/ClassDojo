package com.classDojo.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Enrollment extends Entity {
	private String subject;
	private int teacherId;
	private int studentId;
	private Date created;

	public Enrollment() {
	}

	public Enrollment(int id, String subject, int teacherId, int studentId) {
		super(id);
		this.subject = subject;
		this.teacherId = teacherId;
		this.studentId = studentId;
	}

	// will return a map representation of the Enrollment object
	// will be mostly used when inserting new Enrollment or updating
	// into database
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// putting super object fields into map
		Map<String, Object> superMap = super.map();
		map.putAll(superMap);

		map.put("subject", subject);
		map.put("teacherId", teacherId);
		map.put("studentId", studentId);
		return map;
	}

	public String getsubject() {
		return subject;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public int getStudentId() {
		return studentId;
	}

	public Date getCreated() {
		return created;
	}
}
