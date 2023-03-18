package edu.jcourse.city.web;

import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/check")
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest request) {
        logger.info("{}", request);
        return new PersonResponse();
    }
}
