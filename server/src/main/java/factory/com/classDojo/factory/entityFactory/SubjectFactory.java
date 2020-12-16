package com.classDojo.factory.entityFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import com.classDojo.entities.Subject;
import com.classDojo.entities.meta.tables.Subjects;
import com.classDojo.json.Json;

public class SubjectFactory implements EntityFactory<Subject> {
	private static SubjectFactory instance;

	private SubjectFactory() {
		// nothing goes here
	}

	public static SubjectFactory instance() throws Exception {
		if (instance == null) {
			synchronized (SubjectFactory.class) {
				if (instance == null) {
					instance = new SubjectFactory();
				}
			}
		}
		return instance;
	}

	@Override
	public Subject createFromResultSet(ResultSet rs) throws Exception {
		int id = rs.getInt("id");
		int teacherId = rs.getInt("teacherId");
		String name = rs.getString("name");
		return new Subject(id, teacherId, name);
	}

	@Override
	public List<Subject> createFromResultSet(Result<Record> result) throws Exception {
		if (result == null)
			return null;
		List<Subject> list = new ArrayList<Subject>();
		for (Record r : result) {
			int id = r.getValue(Subjects.SUBJECTS.ID);
			int teacherId = r.getValue(Subjects.SUBJECTS.TEACHERID);
			String name = r.getValue(Subjects.SUBJECTS.NAME);
			list.add(new Subject(id, teacherId, name));
		}
		return list;
	}

	@Override
	public Subject createFromJson(String json) throws Exception {

		return Json.parse(json, Subject.class);
	}

	@Override
	public List<Subject> getListFromJson(String json) throws Exception {

		return null;
	}

}
