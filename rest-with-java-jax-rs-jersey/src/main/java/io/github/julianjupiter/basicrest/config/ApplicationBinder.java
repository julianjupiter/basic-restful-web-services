package io.github.julianjupiter.basicrest.config;

import javax.persistence.EntityManager;

import io.github.julianjupiter.basicrest.repository.ContactRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import io.github.julianjupiter.basicrest.repository.ContactRepositoryImpl;
import io.github.julianjupiter.basicrest.service.ContactService;
import io.github.julianjupiter.basicrest.service.ContactServiceImpl;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bindFactory(ApplicationEntityManagerFactory.class).to(EntityManager.class).in(RequestScoped.class);
		bind(ContactServiceImpl.class).to(ContactService.class).in(RequestScoped.class);
		bind(ContactRepositoryImpl.class).to(ContactRepository.class).in(RequestScoped.class);
	}
	
}
