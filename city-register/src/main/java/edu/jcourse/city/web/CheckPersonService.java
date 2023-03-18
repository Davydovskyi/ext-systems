package edu.jcourse.city.web;

import edu.jcourse.city.dao.DAOProvider;
import edu.jcourse.city.dao.PersonCheckDAO;
import edu.jcourse.city.dao.impl.PoolConnectionBuilder;
import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    private PersonCheckDAO dao;

    @PostConstruct
    public void init() {
        logger.info("START");
        dao = DAOProvider.getInstance().getPersonCheckDAO();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckDAOException {
        logger.info("{}", request);
        return dao.checkPerson(request);
    }
}
