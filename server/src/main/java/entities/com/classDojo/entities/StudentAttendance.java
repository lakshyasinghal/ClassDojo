package com.classDojo.entities;

import java.util.HashMap;
import java.util.Map;

public class StudentAttendance extends Entity {
	private int studentId;
	private String subject;
	private byte attendance;

	public StudentAttendance() {
	}

	public StudentAttendance(int id, int studentId, String subject, byte attendance) {
		super(id);
		this.studentId = studentId;
		this.subject = subject;
		this.attendance = attendance;
	}

	// will return a map representation of the Enrollment object
	// will be mostly used when inserting new Enrollment or updating
	// into database
	public Map<String, Object> map() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// putting super object fields into map
		Map<String, Object> superMap = super.map();
		map.putAll(superMap);

		map.put("studentId", studentId);
		map.put("subject", subject);
		map.put("attendance", attendance);
		return map;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getsubject() {
		return subject;
	}

	public byte getAttendance() {
		return attendance;
	}
}
