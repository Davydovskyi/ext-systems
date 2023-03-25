package edu.jcourse.register.dao.impl;

import edu.jcourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonDAO {

    private EntityManager entityManager;

    public PersonDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public List<Person> findPersons() {
        return entityManager
                .createNamedQuery("Person.findPersons", Person.class)
                .setParameter("personID", 1)
                .getResultList();
    }
}
