package edu.jcourse.register.dao.impl;

import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MarriageDAOImpl implements MarriageDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDAOImpl.class);

    private final EntityManager entityManager;

    public MarriageDAOImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    @Override
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
