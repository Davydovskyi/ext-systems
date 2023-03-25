package edu.jcourse.register.dao.impl;

import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageDAOImpl implements MarriageDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDAOImpl.class);

    private EntityManager entityManager;

    @Override
    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        return null;
    }
}
