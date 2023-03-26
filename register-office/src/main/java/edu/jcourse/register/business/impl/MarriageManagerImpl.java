package edu.jcourse.register.business.impl;

import edu.jcourse.register.business.MarriageManager;
import edu.jcourse.register.dao.DAOProvider;
import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.dao.impl.PersonDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;
import edu.jcourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "marriageService")
public class MarriageManagerImpl implements MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManagerImpl.class);

    private final DAOProvider daoProvider = DAOProvider.getInstance();
    private final MarriageDAO marriageDAO = daoProvider.getMarriageDAO();

    @Autowired
    private PersonDAO personDAO;

    @Override
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");

//        personDAO.findPersons();

        MarriageCertificate marriageCertificate = marriageDAO.findMarriageCertificate(request);
        MarriageResponse response = new MarriageResponse();
        if (marriageCertificate == null) {
            return response;
        }

        response.setExists(true);
        response.setActive(marriageCertificate.isActive());
        response.setEndData(marriageCertificate.getEndDate());

        return response;
    }
}
