package edu.jcourse.city.dao.impl;

import edu.jcourse.city.dao.DAOProvider;
import edu.jcourse.city.dao.PersonCheckDAO;
import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

// TODO доделать тесты
class PersonCheckDAOImplTest {

    @Test
    void checkPerson() throws PersonCheckDAOException {
        PersonRequest request = createRequest("Васильев", "Павел", "Николаевич",
                LocalDate.of(1995, 3, 18), 1, "10", "2", "121");

        PersonCheckDAO dao = DAOProvider.getInstance().getPersonCheckDAO();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse response = dao.checkPerson(request);

        Assertions.assertTrue(response.isRegistered());
        Assertions.assertFalse(response.isTemporal());
    }

    @Test
    void checkPerson2() throws PersonCheckDAOException {
        PersonRequest request = createRequest("Васильева", "Ирина", "Петровна",
                LocalDate.of(1997, 8, 21), 1, "10", "2", "121");

        PersonCheckDAO dao = DAOProvider.getInstance().getPersonCheckDAO();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse response = dao.checkPerson(request);

        Assertions.assertTrue(response.isRegistered());
        Assertions.assertFalse(response.isTemporal());
    }

    private PersonRequest createRequest(String surName, String givenName,
                                        String patronymic, LocalDate dateOfBirth, Integer streetCode,
                                        String building, String extension, String apartment) {
        PersonRequest request = new PersonRequest();
        request.setSurName(surName);
        request.setGivenName(givenName);
        request.setPatronymic(patronymic);
        request.setDateOfBirth(dateOfBirth);
        request.setStreetCode(streetCode);
        request.setBuilding(building);
        request.setExtension(extension);
        request.setApartment(apartment);
        return request;
    }
}