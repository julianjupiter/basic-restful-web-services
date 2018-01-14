package io.github.julianjupiter.basicrest.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {
	@Override
	public Response toResponse(ApplicationException exception) {
		return Response
				.status(exception.getStatus())
				.entity(new ErrorMessage(exception))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
