package com.classDojo.rest.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.classDojo.requestProcessor.TeacherRequestProcessor;

@Path("/api/v1")
public class TeacherResource {
	private static TeacherRequestProcessor processor = TeacherRequestProcessor.instance();

	@POST
	@Path("/teachers")
	@Produces(MediaType.APPLICATION_JSON)
	public String signup(@Context HttpServletRequest req) throws Exception {
		return processor.processSignUpRequest(req);
	}

	@POST
	@Path("/teachers/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@FormParam("email") String email, @FormParam("password") String password) throws Exception {
		return processor.processLoginRequest(email, password);
	}

	@GET
	@Path("/teachers/{teacherId}/subjects")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSubjects(@PathParam("teacherId") String teacherId) throws Exception {
		return processor.processGetSubjectsRequest(Integer.parseInt(teacherId));
	}

	@POST
	@Path("/teachers/subjects")
	@Produces(MediaType.APPLICATION_JSON)
	public String createSubject(@Context HttpServletRequest req) throws Exception {
		return processor.processCreateSubjectRequest(req);
	}

	@DELETE
	@Path("/teachers/{teacherId}/subjects/{subject}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteSubject(@PathParam("teacherId") String teacherId, @PathParam("subject") String subject)
			throws Exception {
		return processor.processDeleteSubjectRequest(Integer.parseInt(teacherId), subject);
	}

	@PUT
	@Path("/attendance/subjects/{subject}/students/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateAttendance(@Context HttpServletRequest req, @PathParam("subject") String subject,
			@PathParam("studentId") String studentId) throws Exception {
		return processor.processUpdateAttendanceRequest(req, subject, Integer.parseInt(studentId));
	}
}
