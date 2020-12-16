package com.classDojo.rest.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.classDojo.requestProcessor.StudentRequestProcessor;

@Path("/api/v1")
public class StudentResource {
	private static StudentRequestProcessor processor = StudentRequestProcessor.instance();

	@POST
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public String signup(@Context HttpServletRequest req) throws Exception {
		return processor.processSignUpRequest(req);
	}

	@POST
	@Path("/students/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@FormParam("email") String email, @FormParam("password") String password) throws Exception {
		return processor.processLoginRequest(email, password);
	}

	@POST
	@Path("/students/enrollment")
	@Produces(MediaType.APPLICATION_JSON)
	public String createEnrollment(@Context HttpServletRequest req) throws Exception {
		return processor.processEnrollmentRequest(req);
	}

	@GET
	@Path("/students/{studentId}/attendance")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAttendance(@PathParam("studentId") String studentId) throws Exception {
		return processor.processGetAttendanceRequest(Integer.parseInt(studentId));
	}
}
