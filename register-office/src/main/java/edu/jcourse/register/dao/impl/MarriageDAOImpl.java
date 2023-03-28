package edu.jcourse.register.dao.impl;

import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MarriageDAOImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        try {
            return entityManager
                    .createNamedQuery("MarriageCertificate.findMarriageCertificate", MarriageCertificate.class)
                    .setParameter("certificateNumber", request.getMarriageCertificateNumber())
                    .getSingleResult();
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return null;
    }
}
