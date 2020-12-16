package com.classDojo.dao.generic;

import java.sql.SQLException;
import java.util.List;

import com.classDojo.entities.Subject;
import com.classDojo.entities.Teacher;

public interface TeacherDao extends Dao<Teacher> {

	// list create update delete subjects

	public boolean login(String email, String password) throws SQLException, Exception;

	public List<Subject> allSubjects(int id) throws SQLException, Exception;

	public boolean createSubject(Subject subject) throws SQLException, Exception;

	public boolean deleteSubject(int teacherId, String subjectName) throws SQLException, Exception;

	public boolean updateAttendance(String subject, int studentId, byte attendance) throws SQLException, Exception;
}
