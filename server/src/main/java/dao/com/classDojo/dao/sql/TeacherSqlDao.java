package com.classDojo.dao.sql;

import static com.classDojo.entities.meta.tables.Studentattendances.STUDENTATTENDANCES;
import static com.classDojo.entities.meta.tables.Subjects.SUBJECTS;
import static com.classDojo.entities.meta.tables.Teachers.TEACHERS;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import com.classDojo.connectionPool.ConnectionPoolManager;
import com.classDojo.dao.generic.TeacherDao;
import com.classDojo.entities.Subject;
import com.classDojo.entities.Teacher;
import com.classDojo.factory.entityFactory.SubjectFactory;
import com.classDojo.factory.misc.JOOQDSLContextFactory;

public class TeacherSqlDao implements TeacherDao {
	private static final Logger LOGGER = Logger.getLogger(TeacherSqlDao.class.getName());
	private static JOOQDSLContextFactory dslContextFactory = JOOQDSLContextFactory.instance();
	private static TeacherSqlDao instance = new TeacherSqlDao();

	private TeacherSqlDao() {
	}

	public static TeacherSqlDao instance() {
		return instance;
	}

	@Override
	public boolean create(Teacher teacher) throws SQLException, Exception {
		LOGGER.info("Getting sql connection");
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt
					.insertInto(TEACHERS, TEACHERS.EMAIL, TEACHERS.PASSWORD, TEACHERS.NAME, TEACHERS.AGE,
							TEACHERS.MOBILE)
					.values(teacher.getEmail(), teacher.getPassword(), teacher.getName(), teacher.getAge(),
							teacher.getMobile())
					.execute();
			LOGGER.info("Query executed successfully.");
			return count == 1;
		}
	}

	@Override
	public Teacher getById(int id) {

		return null;
	}

	@Override
	public boolean login(String email, String password) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt.selectCount().from(TEACHERS).where(TEACHERS.EMAIL.eq(email))
					.and(TEACHERS.PASSWORD.eq(password)).fetchOneInto(Integer.class);
			return count == 1;
		}
	}

	@Override
	public List<Subject> allSubjects(int id) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			Result<Record> result = ctxt.select().from(SUBJECTS).where(SUBJECTS.TEACHERID.eq(id)).fetch();
			return SubjectFactory.instance().createFromResultSet(result);
		}
	}

	@Override
	public boolean createSubject(Subject subject) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt.insertInto(SUBJECTS, SUBJECTS.TEACHERID, SUBJECTS.NAME)
					.values(subject.getTeacherId(), subject.getName()).onDuplicateKeyUpdate()
					.set(SUBJECTS.TEACHERID, subject.getTeacherId()).set(SUBJECTS.NAME, subject.getName()).execute();
			return count == 1;
		}
	}

	@Override
	public boolean deleteSubject(int teacherId, String subjectName) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt.deleteFrom(SUBJECTS).where(SUBJECTS.TEACHERID.eq(teacherId))
					.and(SUBJECTS.NAME.eq(subjectName)).execute();
			return count == 1;
		}
	}

	@Override
	public boolean updateAttendance(String subject, int studentId, byte attendance) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt.update(STUDENTATTENDANCES).set(STUDENTATTENDANCES.ATTENDANCE, attendance)
					.where(STUDENTATTENDANCES.SUBJECT.eq(subject)).and(STUDENTATTENDANCES.STUDENTID.eq(studentId))
					.execute();
			return count == 1;
		}
	}

}
