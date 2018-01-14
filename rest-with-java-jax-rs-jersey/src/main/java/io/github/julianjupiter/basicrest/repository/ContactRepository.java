package io.github.julianjupiter.basicrest.repository;

import java.util.List;

import io.github.julianjupiter.basicrest.domain.Contact;
import io.github.julianjupiter.basicrest.util.ApplicationException;

public interface ContactRepository {
	
	List<Contact> findAll() throws ApplicationException;

	Contact findById(long id) throws ApplicationException;

	Contact save(Contact user) throws ApplicationException;

	Contact update(Contact user) throws ApplicationException;

	void delete(long id) throws ApplicationException;	
	
}
