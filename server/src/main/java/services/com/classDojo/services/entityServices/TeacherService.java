package com.classDojo.services.entityServices;

import java.util.List;

import org.apache.log4j.Logger;

import com.classDojo.dao.generic.TeacherDao;
import com.classDojo.dao.sql.TeacherSqlDao;
import com.classDojo.entities.Subject;
import com.classDojo.entities.Teacher;
import com.classDojo.util.PasswordUtils;

public class TeacherService {
	private static final Logger LOGGER = Logger.getLogger(TeacherService.class.getName());
	private static TeacherService instance = new TeacherService();
	private static TeacherDao teacherDao = TeacherSqlDao.instance();

	private TeacherService() {
	}

	public static TeacherService instance() {
		return instance;
	}

	public boolean signUp(Teacher teacher) throws Exception {
		LOGGER.info("signing up...");
		teacher.setPassword(PasswordUtils.encryptPassword(teacher.getPassword()));
		return teacherDao.create(teacher);
	}

	public boolean login(String email, String password) throws Exception {
		password = PasswordUtils.encryptPassword(password);
		return teacherDao.login(email, password);
	}

	public List<Subject> getSubjects(int teacherId) throws Exception {
		return teacherDao.allSubjects(teacherId);
	}

	public boolean createSubject(Subject subject) throws Exception {
		return teacherDao.createSubject(subject);
	}

	public boolean deleteSubject(int teacherId, String subjectName) throws Exception {
		return teacherDao.deleteSubject(teacherId, subjectName);
	}

	public boolean updateAttendance(String subject, int studentId, byte attendance) throws Exception {
		return teacherDao.updateAttendance(subject, studentId, attendance);
	}
}
