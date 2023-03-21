package edu.jcourse.register.business.impl;

import edu.jcourse.register.business.MarriageManager;
import edu.jcourse.register.dao.DAOProvider;
import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.view.MarriageRequest;
import edu.jcourse.register.view.MarriageResponse;

public class MarriageManagerImpl implements MarriageManager {

    private final DAOProvider daoProvider = DAOProvider.getInstance();
    private final MarriageDAO marriageDAO = daoProvider.getMarriageDAO();

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        throw new UnsupportedOperationException("Unsupported yet");
    }
}
