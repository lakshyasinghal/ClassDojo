package com.classDojo.requestProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.classDojo.entities.Subject;
import com.classDojo.entities.Teacher;
import com.classDojo.factory.entityFactory.SubjectFactory;
import com.classDojo.factory.entityFactory.TeacherFactory;
import com.classDojo.json.Json;
import com.classDojo.response.Response;
import com.classDojo.services.entityServices.TeacherService;
import com.fasterxml.jackson.databind.JsonNode;

public class TeacherRequestProcessor extends AbstractRequestProcessor {
	private static final Logger LOGGER = Logger.getLogger(TeacherRequestProcessor.class.getName());
	private static final TeacherRequestProcessor instance = new TeacherRequestProcessor();
	private static final TeacherService teacherService = TeacherService.instance();

	private TeacherRequestProcessor() {
	}

	public static TeacherRequestProcessor instance() {
		return instance;
	}

	public String processSignUpRequest(HttpServletRequest req) throws Exception {
		LOGGER.info("Processing Signup Request");
		boolean success = false;
		String msg = null;
		try {
			Teacher teacher = TeacherFactory.instance().createFromJson(getJsonFromRequest(req));
			success = teacherService.signUp(teacher);
			if (success) {
				msg = "CREATED SUCCESSFULLY";
			} else
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
			success = teacherService.login(email, password);
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

	public String processGetSubjectsRequest(int teacherId) throws Exception {
		LOGGER.info("Processing GetSubjects Request");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Subject> subjects = null;
		boolean success = false;
		String msg;
		try {
			subjects = teacherService.getSubjects(teacherId);
			success = true;
			if (subjects != null && subjects.size() > 0)
				msg = "RETRIEVED SUCCESSFULLY";
			else
				msg = "NO RESULTS FOUND";
			resultMap.put("subjects", subjects);
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, resultMap);
		return response.process();
	}

	public String processCreateSubjectRequest(HttpServletRequest req) throws Exception {
		LOGGER.info("Processing CreateSubject Request");
		boolean success = false;
		String msg = null;
		try {
			Subject subject = SubjectFactory.instance().createFromJson(getJsonFromRequest(req));
			success = teacherService.createSubject(subject);
			if (success) {
				msg = "CREATED SUCCESSFULLY";
			} else
				msg = "COULD NOT CREATE";
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, null);
		return response.process();
	}

	public String processDeleteSubjectRequest(int teacherId, String subjectName) throws Exception {
		LOGGER.info("Processing DeleteSubject Request");
		boolean success = false;
		String msg = null;
		try {
			success = teacherService.deleteSubject(teacherId, subjectName);
			if (success) {
				msg = "DELETED SUCCESSFULLY";
			} else
				msg = "COULD NOT DELETE";
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, null);
		return response.process();
	}

	public String processUpdateAttendanceRequest(HttpServletRequest req, String subject, int studentId)
			throws Exception {
		LOGGER.info("Processing UpdateAttendance Request");
		boolean success = false;
		String msg = null;
		try {
			JsonNode rootNode = Json.parse(getJsonFromRequest(req));
			byte attendance = (byte) rootNode.get("attendance").asInt();
			success = teacherService.updateAttendance(subject, studentId, attendance);
			if (success) {
				msg = "UPDATED SUCCESSFULLY";
			} else
				msg = "COULD NOT UPDATE";
		} catch (Exception ex) {
			log(ex, LOGGER);
			msg = errMsg();
		}

		Response response = responseFactory.getJsonResponse(success, msg, null);
		return response.process();
	}
}
