package edu.jcourse.register.manager;

import edu.jcourse.register.domain.Person;
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

        Session session1 = sessionFactory.openSession();
        Person person1 = session1.get(Person.class, id);
        System.out.println(person1);
        session1.close();

        session = sessionFactory.openSession();
        Query<Person> from_person = session.createQuery("FROM Person", Person.class);


        System.out.println(from_person.list());
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
