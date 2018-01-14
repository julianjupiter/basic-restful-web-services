package io.github.julianjupiter.basicrest.service;

import java.util.List;

import io.github.julianjupiter.basicrest.domain.Contact;
import io.github.julianjupiter.basicrest.util.ApplicationException;

public interface ContactService {
	
	List<Contact> findAll() throws ApplicationException;

	Contact findById(long id) throws ApplicationException;

	Contact save(Contact contact) throws ApplicationException;

	Contact update(Contact contact) throws ApplicationException;

	void delete(long id) throws ApplicationException;	
	
}
