package com.classDojo.factory.entityFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import com.classDojo.entities.StudentAttendance;
import com.classDojo.entities.meta.tables.Studentattendances;

public class StudentAttendanceFactory implements EntityFactory<StudentAttendance> {
	private static StudentAttendanceFactory instance;

	private StudentAttendanceFactory() {
		// nothing goes here
	}

	public static StudentAttendanceFactory instance() throws Exception {
		if (instance == null) {
			synchronized (StudentAttendanceFactory.class) {
				if (instance == null) {
					instance = new StudentAttendanceFactory();
				}
			}
		}
		return instance;
	}

	@Override
	public StudentAttendance createFromResultSet(ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		int studentId = rs.getInt("studentId");
		String subject = rs.getString("subject");
		byte attendance = rs.getByte("attendance");
		return new StudentAttendance(id, studentId, subject, attendance);
	}

	@Override
	public List<StudentAttendance> createFromResultSet(Result<Record> result) throws Exception {
		if (result == null)
			return null;
		List<StudentAttendance> list = new ArrayList<StudentAttendance>();
		for (Record r : result) {
			int id = r.getValue(Studentattendances.STUDENTATTENDANCES.ID);
			int studentId = r.getValue(Studentattendances.STUDENTATTENDANCES.STUDENTID);
			String subject = r.getValue(Studentattendances.STUDENTATTENDANCES.SUBJECT);
			byte attendance = r.getValue(Studentattendances.STUDENTATTENDANCES.ATTENDANCE);
			list.add(new StudentAttendance(id, studentId, subject, attendance));
		}
		return list;
	}

	@Override
	public StudentAttendance createFromJson(String json) throws Exception {

		return null;
	}

	@Override
	public List<StudentAttendance> getListFromJson(String json) throws Exception {

		return null;
	}

}
