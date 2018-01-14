package io.github.julianjupiter.basicrest.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import io.github.julianjupiter.basicrest.domain.Contact;
import io.github.julianjupiter.basicrest.util.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.julianjupiter.basicrest.util.ApplicationException;
import io.github.julianjupiter.basicrest.util.JpaUtil;

public class ContactRepositoryImpl implements ContactRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactRepositoryImpl.class);
    @Inject
    private EntityManager em;

    @Override
    public List<Contact> findAll() throws ApplicationException {
        try {
            TypedQuery<Contact> query = em.createNamedQuery("Contact.findAll", Contact.class);

            return query.getResultList();
        } catch (Exception exception) {
            LOGGER.error("Unable to retrieve all contacts.");
            throw new ApplicationException(
                    Response.Status.FORBIDDEN.getStatusCode(),
                    ErrorCode.E4003,
                    "Unable to retrieve all contacts.",
                    LocalDateTime.now());
        }
    }

    @Override
    public Contact findById(long id) throws ApplicationException {
        try {
            return em.find(Contact.class, id);
        } catch (Exception exception) {
            LOGGER.error("Unable to retrieve contact with ID {}.", id);
            throw new ApplicationException(
                    Response.Status.FORBIDDEN.getStatusCode(),
                    ErrorCode.E4003,
                    "Unable to retrieve contact with ID " + id + ".",
                    LocalDateTime.now());
        }
    }

    @Override
    public Contact save(Contact contact) throws ApplicationException {
        return null;
    }

    @Override
    public Contact update(Contact contact) throws ApplicationException {
        return null;
    }

    @Override
    public void delete(long id) throws ApplicationException {
        Contact contact = em.find(Contact.class, id);
        try {
            JpaUtil.beginTransaction(em);
            em.remove(contact);
            JpaUtil.commitTransaction(em);
            LOGGER.info("User deleted.");
        } catch (Exception exception) {
            JpaUtil.rollbackTransaction(em);
            LOGGER.error("User not deleted.");
            throw new ApplicationException(
                    Response.Status.FORBIDDEN.getStatusCode(),
                    ErrorCode.E4003,
                    "",
                    LocalDateTime.now());
        }
    }

}
