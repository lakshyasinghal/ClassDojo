package com.classDojo.dao.generic;

import java.sql.SQLException;
import java.util.List;

import com.classDojo.entities.Enrollment;
import com.classDojo.entities.Student;
import com.classDojo.entities.StudentAttendance;

public interface StudentDao extends Dao<Student> {

	public boolean login(String email, String password) throws SQLException, Exception;

	public boolean enrol(Enrollment enrollment, StudentAttendance studentAttendance) throws SQLException, Exception;

	public List<StudentAttendance> attendance(int id) throws SQLException, Exception;
}
