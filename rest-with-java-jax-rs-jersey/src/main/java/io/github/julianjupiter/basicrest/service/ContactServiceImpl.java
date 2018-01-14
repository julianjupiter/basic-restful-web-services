package io.github.julianjupiter.basicrest.service;

import java.util.List;

import javax.inject.Inject;

import io.github.julianjupiter.basicrest.domain.Contact;
import io.github.julianjupiter.basicrest.repository.ContactRepository;
import io.github.julianjupiter.basicrest.util.ApplicationException;

public class ContactServiceImpl implements ContactService {
	
	@Inject
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAll() throws ApplicationException {
		return this.contactRepository.findAll();
	}

	@Override
	public Contact findById(long id) throws ApplicationException {
		return this.contactRepository.findById(id);
	}

	@Override
	public Contact save(Contact user) throws ApplicationException {
		return this.contactRepository.save(user);
	}

	@Override
	public Contact update(Contact user) throws ApplicationException {
		return this.contactRepository.update(user);
	}

	@Override
	public void delete(long id) throws ApplicationException {		
		this.contactRepository.delete(id);
	}
	
}
