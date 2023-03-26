package edu.jcourse.register.rest;

import edu.jcourse.register.business.BusinessProvider;
import edu.jcourse.register.business.MarriageManager;
import edu.jcourse.register.view.MarriageRequest;
import edu.jcourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);

    private final BusinessProvider provider = BusinessProvider.getInstance();
    private MarriageManager marriageManager = provider.getMarriageManager();

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(request);
    }
}