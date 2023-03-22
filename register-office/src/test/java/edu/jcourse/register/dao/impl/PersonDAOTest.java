package edu.jcourse.register.dao.impl;

import edu.jcourse.register.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonDAOTest {

    @Test
    void findPersons() {
        PersonDAO personDAO = new PersonDAO();
        List<Person> persons = personDAO.findPersons();

        persons.forEach(person -> {
            System.out.println(person.getFirstName());
            System.out.println(person.getClass().getSimpleName());
            System.out.println(person.getPassports().size());
        });
    }
}