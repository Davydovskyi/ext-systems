package edu.jcourse.register.dao.impl;

import edu.jcourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findPersons() {
        return entityManager
                .createNamedQuery("Person.findPersons", Person.class)
                .setParameter("personID", 1)
                .getResultList();
    }
}
