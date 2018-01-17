package io.github.julianjupiter.basicrest.util;

import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaUtil {
	private static Logger logger = LoggerFactory.getLogger(JpaUtil.class);
	
	private JpaUtil() {
		
	}
	
	public static void beginTransaction(EntityManager entityManager) {
		 if (!entityManager.getTransaction().isActive()) {
			 entityManager.getTransaction().begin();
			 logger.info("Transaction started.");
		 }
	}

    public static void commitTransaction(EntityManager entityManager) {
        if (entityManager.getTransaction().isActive()) {
        	entityManager.getTransaction().commit();
			logger.info("Transaction committed.");
        }
    }

    public static void rollbackTransaction(EntityManager entityManager) {
        if (entityManager.getTransaction().isActive()) {
        	entityManager.getTransaction().rollback();
			logger.info("Transaction rolled back.");
        }
    }
}
