package edu.jcourse.register.business.impl;

import edu.jcourse.register.business.MarriageManager;
import edu.jcourse.register.dao.DAOProvider;
import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.dao.impl.PersonDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.domain.Person;
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

@Service(value = "marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManagerImpl implements MarriageManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageManagerImpl.class);

    private final DAOProvider daoProvider = DAOProvider.getInstance();
    @Autowired
    private final MarriageDAO marriageDAO = daoProvider.getMarriageDAO();
    @Autowired
    private PersonDAO personDAO;

    @Transactional
    @Override
    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");

        personDAO.findPersons();

        Person person = new PersonMale();
        person.setFirstName("1");
        person.setLastName("2");
        person.setPatronymic("3");
        person.setDateOfBirth(LocalDate.of(1991, 3, 12));

        personDAO.addPerson(person);

        MarriageCertificate marriageCertificate = marriageDAO.findMarriageCertificate(request);
        MarriageResponse response = new MarriageResponse();
        if (marriageCertificate == null) {
            return response;
        }

        response.setExists(true);
        response.setActive(marriageCertificate.isActive());
        response.setEndData(marriageCertificate.getEndDate());

        return response;
    }
}
