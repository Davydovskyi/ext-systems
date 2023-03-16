package edu.jcourse.city.dao;

import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;

public interface PersonCheckDAO {
    void setConnectionBuilder(ConnectionBuilder connectionBuilder);

    PersonResponse checkPerson(PersonRequest request) throws PersonCheckDAOException;
}
