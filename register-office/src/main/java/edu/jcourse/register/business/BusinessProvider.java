package edu.jcourse.register.business;

import edu.jcourse.register.business.impl.MarriageManagerImpl;

public class BusinessProvider {

    private static BusinessProvider instance;

    private final MarriageManager marriageManager;

    private BusinessProvider() {
        marriageManager = new MarriageManagerImpl();
    }

    public static BusinessProvider getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (BusinessProvider.class) {
            if (instance == null) {
                instance = new BusinessProvider();
            }

            return instance;
        }
    }

    public MarriageManager getMarriageManager() {
        return marriageManager;
    }
}
