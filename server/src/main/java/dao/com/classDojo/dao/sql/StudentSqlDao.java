package com.classDojo.dao.sql;

import static com.classDojo.entities.meta.tables.Enrollments.ENROLLMENTS;
import static com.classDojo.entities.meta.tables.Studentattendances.STUDENTATTENDANCES;
import static com.classDojo.entities.meta.tables.Students.STUDENTS;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import com.classDojo.connectionPool.ConnectionPoolManager;
import com.classDojo.dao.generic.StudentDao;
import com.classDojo.entities.Enrollment;
import com.classDojo.entities.Student;
import com.classDojo.entities.StudentAttendance;
import com.classDojo.factory.entityFactory.StudentAttendanceFactory;
import com.classDojo.factory.misc.JOOQDSLContextFactory;

public class StudentSqlDao implements StudentDao {
	private static JOOQDSLContextFactory dslContextFactory = JOOQDSLContextFactory.instance();
	private static StudentSqlDao instance = new StudentSqlDao();

	private StudentSqlDao() {
	}

	public static StudentSqlDao instance() {
		return instance;
	}

	@Override
	public boolean create(Student student) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt
					.insertInto(STUDENTS, STUDENTS.EMAIL, STUDENTS.PASSWORD, STUDENTS.NAME, STUDENTS.AGE,
							STUDENTS.MOBILE)
					.values(student.getEmail(), student.getPassword(), student.getName(), student.getAge(),
							student.getMobile())
					.execute();
			return count == 1;
		}
	}

	@Override
	public Student getById(int id) {
		return null;
	}

	@Override
	public boolean login(String email, String password) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int count = ctxt.selectCount().from(STUDENTS).where(STUDENTS.EMAIL.eq(email))
					.and(STUDENTS.PASSWORD.eq(password)).fetchOneInto(Integer.class);
			return count == 1;
		}
	}

	@Override
	public boolean enrol(Enrollment enrollment, StudentAttendance studentAttendance) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			int updateCount = ctxt.transactionResult(config -> {
				int count = 0;
				DSLContext innerCtxt = DSL.using(config);
				count += innerCtxt
						.insertInto(ENROLLMENTS, ENROLLMENTS.SUBJECT, ENROLLMENTS.TEACHERID, ENROLLMENTS.STUDENTID)
						.values(enrollment.getsubject(), enrollment.getTeacherId(), enrollment.getStudentId())
						.execute();
				count += innerCtxt
						.insertInto(STUDENTATTENDANCES, STUDENTATTENDANCES.STUDENTID, STUDENTATTENDANCES.SUBJECT,
								STUDENTATTENDANCES.ATTENDANCE)
						.values(studentAttendance.getStudentId(), studentAttendance.getsubject(),
								studentAttendance.getAttendance())
						.execute();
				return count;
			});
			return updateCount == 2;
		}
	}

	@Override
	public List<StudentAttendance> attendance(int studentId) throws SQLException, Exception {
		try (Connection con = ConnectionPoolManager.getConnection()) {
			DSLContext ctxt = dslContextFactory.getDSLContext(con);
			Result<Record> result = ctxt.select().from(STUDENTATTENDANCES)
					.where(STUDENTATTENDANCES.STUDENTID.eq(studentId)).fetch();
			return StudentAttendanceFactory.instance().createFromResultSet(result);
		}
	}

}
