package com.classDojo.requestProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.classDojo.entities.Enrollment;
import com.classDojo.entities.Student;
import com.classDojo.entities.StudentAttendance;
import com.classDojo.factory.entityFactory.EnrollmentFactory;
import com.classDojo.factory.entityFactory.StudentFactory;
import com.classDojo.response.Response;
import com.classDojo.services.entityServices.StudentService;

public class StudentRequestProcessor extends AbstractRequestProcessor {
	private static final Logger LOGGER = Logger.getLogger(StudentRequestProcessor.class.getName());
	private static StudentRequestProcessor instance = new StudentRequestProcessor();
	private static final StudentService studentService = StudentService.instance();

	private StudentRequestProcessor() {
	}

	public static StudentRequestProcessor instance() {
		return instance;
	}

	public String processSignUpRequest(HttpServletRequest req) throws Exception {
		LOGGER.info("Processing Signup Request");
		boolean success = false;
		String msg = null;
		try {
			Student student = StudentFactory.instance().createFromJson(getJsonFromRequest(req));
			success = studentService.signUp(student);
			if (success)
				msg = "CREATED SUCCESSFULLY";
			else
				msg = "COULD NOT CREATE";
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, null);
		return response.process();
	}

	public String processLoginRequest(String email, String password) throws Exception {
		LOGGER.info("Processing Login Request");
		boolean success = false;
		String msg = null;
		try {
			success = studentService.login(email, password);
			if (success)
				msg = "LOGIN SUCCESSFUL";
			else
				msg = "INVALID CREDENTIALS";
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, null);
		return response.process();
	}

	public String processEnrollmentRequest(HttpServletRequest req) throws Exception {
		LOGGER.info("Processing Enrollment Request");
		boolean success = false;
		String msg = null;
		try {
			Enrollment enrollment = EnrollmentFactory.instance().createFromJson(getJsonFromRequest(req));
			success = studentService.enrol(enrollment);
			if (success)
				msg = "CREATED SUCCESSFULLY";
			else
				msg = "COULD NOT CREATE";
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, null);
		return response.process();
	}

	public String processGetAttendanceRequest(int studentId) throws Exception {
		LOGGER.info("Processing GetAttendance Request");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<StudentAttendance> attendanceList = null;
		boolean success = false;
		String msg;
		try {
			attendanceList = studentService.getAttendance(studentId);
			if (attendanceList != null && attendanceList.size() > 0) {
				success = true;
				msg = "RETRIEVED SUCCESSFULLY";
			} else
				msg = "NO RESULTS FOUND";
			resultMap.put("attendanceList", attendanceList);
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, resultMap);
		return response.process();
	}
}
