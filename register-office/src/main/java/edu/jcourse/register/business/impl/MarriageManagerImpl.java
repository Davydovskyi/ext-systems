package edu.jcourse.register.business.impl;

import edu.jcourse.register.business.MarriageManager;
import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;
import edu.jcourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManagerImpl implements MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManagerImpl.class);

    private MarriageDAO marriageDAO;

    @Autowired
    public void setMarriageDAO(MarriageDAO marriageDAO) {
        this.marriageDAO = marriageDAO;
    }

    @Transactional
    @Override
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");

        MarriageCertificate marriageCertificate = null;

        List<MarriageCertificate> certificates = marriageDAO.findByNumber(request.getMarriageCertificateNumber());
        if (!certificates.isEmpty()) {
            marriageCertificate = certificates.get(0);
        }

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
