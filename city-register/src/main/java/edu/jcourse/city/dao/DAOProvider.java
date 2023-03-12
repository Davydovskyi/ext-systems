package edu.jcourse.city.dao;

import edu.jcourse.city.dao.impl.PersonCheckDAOImpl;

public class DAOProvider {

    private static volatile DAOProvider instance;

    private final PersonCheckDAO personCheckDAO;

    private DAOProvider() {
        personCheckDAO = new PersonCheckDAOImpl();
    }

    public static DAOProvider getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (DAOProvider.class) {
            if (instance == null) {
                instance = new DAOProvider();
            }
            return instance;
        }
    }

    public PersonCheckDAO getPersonCheckDAO() {
        return personCheckDAO;
    }
}
