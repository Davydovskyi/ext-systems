package edu.jcourse.city.web;

import edu.jcourse.city.dao.DAOProvider;
import edu.jcourse.city.dao.PersonCheckDAO;
import edu.jcourse.city.dao.impl.PoolConnectionBuilder;
import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);
    private transient PersonCheckDAO dao;

    @Override
    public void init() throws ServletException {
        logger.info("Servlet is created");
        dao = DAOProvider.getInstance().getPersonCheckDAO();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        PersonRequest request = new PersonRequest();
        request.setSurName(req.getParameter("surname"));
        request.setGivenName(req.getParameter("givenName"));
        request.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        request.setDateOfBirth(dateOfBirth);
        request.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        request.setBuilding(req.getParameter("building"));
        request.setExtension(req.getParameter("extension"));
        request.setApartment(req.getParameter("apartment"));

        try {
            PersonResponse response = dao.checkPerson(request);
            if (response.isRegistered()) {
                resp.getWriter().println("Registered");
            } else {
                resp.getWriter().println("Not registered");
            }
        } catch (PersonCheckDAOException e) {
            e.printStackTrace();
        }
    }
}
