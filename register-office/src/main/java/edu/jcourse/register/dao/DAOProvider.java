package edu.jcourse.register.dao;

import edu.jcourse.register.dao.impl.MarriageDAOImpl;

public class DAOProvider {

    private static DAOProvider instance;

    private final MarriageDAO marriageDAO;

    private DAOProvider() {
        marriageDAO = new MarriageDAOImpl();
    }

    public static DAOProvider getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (DAOProvider.class) {
            if (instance == null) {
                instance = new DAOProvider();
            }
        }
        return instance;
    }

    public MarriageDAO getMarriageDAO() {
        return marriageDAO;
    }
}
