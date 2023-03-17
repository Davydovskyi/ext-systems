package edu.jcourse.city.web;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/check")
public class CheckPersonService {

    @GET
    public String checkPerson() {
        return "Simple String";
    }
}
