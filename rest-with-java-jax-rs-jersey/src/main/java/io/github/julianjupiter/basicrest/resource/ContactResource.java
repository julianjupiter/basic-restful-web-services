package io.github.julianjupiter.basicrest.resource;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.julianjupiter.basicrest.domain.Contact;
import io.github.julianjupiter.basicrest.service.ContactService;
import io.github.julianjupiter.basicrest.util.ApplicationException;
import io.github.julianjupiter.basicrest.util.ErrorCode;

@Path("/contacts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactResource.class);
	@Inject
	private ContactService contactService;
	
	@GET
	public List<Contact> findAll() throws ApplicationException {
		LOGGER.info("Getting all contacts...");
				
		return this.contactService.findAll();
	}
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") long id) throws ApplicationException {
		LOGGER.info("Getting a contact...");
		
		Contact contact = this.contactService.findById(id);
		
		if (null == contact) {
			throw new ApplicationException(
					Response.Status.NOT_FOUND.getStatusCode(),
					ErrorCode.E4004,
					"Contact with ID " + id + " not found.",
					LocalDateTime.now());
		}
		
		return Response.status(Response.Status.OK).entity(contact).build();
	}
	
	@POST
	public Response create(Contact contact) throws ApplicationException {
		LOGGER.info("Creating a contact...");
		
		if (null != contact) {
			LocalDateTime createdAt = contact.getCreatedAt() != null ? contact.getCreatedAt() : LocalDateTime.now();
			contact.setCreatedAt(createdAt);
			this.contactService.save(contact);
			
			return Response
					.status(Response.Status.CREATED)
					.entity(contact)
					.build();
		} else {
			throw new ApplicationException(
					Response.Status.BAD_REQUEST.getStatusCode(), 
					ErrorCode.E4001,
					"Unable to create resource.",
					LocalDateTime.now());
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) throws ApplicationException {
		Contact contact = this.contactService.findById(id);
		
		if (null != contact) {
			this.contactService.delete(id);
			
			return Response
					.status(Response.Status.NO_CONTENT)
					.build();
		} else {
			throw new ApplicationException(
					Response.Status.BAD_REQUEST.getStatusCode(), 
					ErrorCode.E4001,
					"Resource with ID " + id + " does not exist.",
					LocalDateTime.now());
		}
	}

	@PATCH
	@Path("{id}")
	public Response update(@PathParam("id") long id, Contact contact) throws ApplicationException {
		Contact existingContact = this.contactService.findById(id);

		if (null == existingContact) {
			throw new ApplicationException(
					Response.Status.BAD_REQUEST.getStatusCode(),
					ErrorCode.E4001,
					"Resource with ID " + id + " does not exist.",
					LocalDateTime.now());
		}

		return null;
	}
}
