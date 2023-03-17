package edu.jcourse.city.web;

import edu.jcourse.city.domain.PersonResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/check")
public class CheckPersonService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(@PathParam("id") int id,
                                      @QueryParam("name") String name) {
        return new PersonResponse();
    }
}
