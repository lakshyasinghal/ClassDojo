package com.classDojo.services.entityServices;

import java.util.List;

import com.classDojo.dao.generic.StudentDao;
import com.classDojo.dao.sql.StudentSqlDao;
import com.classDojo.entities.Enrollment;
import com.classDojo.entities.Student;
import com.classDojo.entities.StudentAttendance;
import com.classDojo.util.PasswordUtils;

public class StudentService {
	private static StudentService instance = new StudentService();
	private static StudentDao studentDao = StudentSqlDao.instance();

	private StudentService() {
	}

	public static StudentService instance() {
		return instance;
	}

	public boolean signUp(Student Student) throws Exception {
		Student.setPassword(PasswordUtils.encryptPassword(Student.getPassword()));
		return studentDao.create(Student);
	}

	public boolean login(String email, String password) throws Exception {
		password = PasswordUtils.encryptPassword(password);
		return studentDao.login(email, password);
	}

	public boolean enrol(Enrollment enrollment) throws Exception {
		StudentAttendance studentAttendance = new StudentAttendance(-1, enrollment.getStudentId(),
				enrollment.getsubject(), (byte) 0);
		return studentDao.enrol(enrollment, studentAttendance);
	}

	public List<StudentAttendance> getAttendance(int studentId) throws Exception {
		return studentDao.attendance(studentId);
	}
}
