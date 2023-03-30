package edu.jcourse.register.business.impl;

import edu.jcourse.register.business.MarriageManager;
import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.dao.impl.PersonDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.domain.Person;
import edu.jcourse.register.domain.PersonFemale;
import edu.jcourse.register.domain.PersonMale;
import edu.jcourse.register.view.MarriageRequest;
import edu.jcourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service(value = "marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManagerImpl implements MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManagerImpl.class);

    //    private final DAOProvider daoProvider = DAOProvider.getInstance();
    @Autowired
    private MarriageDAO marriageDAO;
    @Autowired
    private PersonDAO personDAO;

    @Transactional
    @Override
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");

        personDAO.addPerson(getPerson(1));
        personDAO.addPerson(getPerson(2));

        MarriageCertificate marriageCertificate1 = getMarriageCertificate();
        marriageDAO.saveAndFlush(marriageCertificate1);

//        List<MarriageCertificate> all = marriageDAO.findAll();

        List<MarriageCertificate> byNumber = marriageDAO.findByNumber("12345");
        byNumber.forEach(m -> LOGGER.info("MC:{}", m.getMarriageCertificateId()));
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>");
        List<MarriageCertificate> byNum = marriageDAO.findByNum("98765");
        byNum.forEach(m -> LOGGER.info("MC:{}", m.getMarriageCertificateId()));
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>");
        List<MarriageCertificate> something = marriageDAO.findSomething("98765");
        something.forEach(m -> LOGGER.info("MC:{}", m.getMarriageCertificateId()));


        MarriageCertificate marriageCertificate = null;
        MarriageResponse response = new MarriageResponse();
//        if (marriageCertificate == null) {
//            return response;
//        }
//
//        response.setExists(true);
//        response.setActive(marriageCertificate.isActive());
//        response.setEndData(marriageCertificate.getEndDate());

        return response;
    }

    private Person getPerson(int sex) {
        Person person = sex == 1 ? new PersonFemale() : new PersonMale();
        person.setFirstName("1_" + sex);
        person.setLastName("2_" + sex);
        person.setPatronymic("3_" + sex);
        person.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return person;
    }

    private MarriageCertificate getMarriageCertificate() {
        MarriageCertificate certificate = new MarriageCertificate();
        certificate.setIssueDate(LocalDate.now());
        certificate.setNumber("98765");
        certificate.setActive(true);
        List<Person> persons = personDAO.findPersons();
        persons.forEach(person -> {
            if (person instanceof PersonMale personMale) {
                certificate.setHusband(personMale);
            } else {
                certificate.setWife((PersonFemale) person);
            }
        });
        return certificate;
    }
}
