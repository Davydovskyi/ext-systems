package edu.jcourse.register.manager;

import edu.jcourse.register.domain.Person;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class PersonManager {

    public static void main(String[] args) {
//        sessionExample();

        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("persistence");

        EntityManager entityManager = managerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Person person = new Person();
        person.setFirstName("Алексей");
        person.setLastName("Федоров");

        entityManager.persist(person);
        System.out.println(person.getPersonId());

        transaction.commit();
        entityManager.close();

        entityManager = managerFactory.createEntityManager();
        TypedQuery<Person> from_person = entityManager.createQuery("FROM Person", Person.class);
        from_person.getResultList().forEach(System.out::println);

        entityManager.close();
    }

    private static void sessionExample() {
        SessionFactory sessionFactory = buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setFirstName("Василий");
        person.setLastName("Сидоров");

        session.persist(person);
        Object id = session.getIdentifier(person);
        System.out.println(id);

        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        Person person1 = session.get(Person.class, id);
        System.out.println(person1);
        session.close();

        session = sessionFactory.openSession();
        Query<Person> from_person = session.createQuery("FROM Person", Person.class);

        from_person.list().forEach(System.out::println);
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
