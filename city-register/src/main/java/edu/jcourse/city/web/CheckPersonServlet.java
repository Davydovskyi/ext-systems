package edu.jcourse.city.web;

import edu.jcourse.city.dao.DAOProvider;
import edu.jcourse.city.dao.PersonCheckDAO;
import edu.jcourse.city.domain.PersonRequest;
import edu.jcourse.city.domain.PersonResponse;
import edu.jcourse.city.exception.PersonCheckDAOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String surname = req.getParameter("surname");

        PersonRequest request = new PersonRequest();
        request.setSurName(surname);
        request.setGivenName("Павел");
        request.setPatronymic("Николаевич");
        request.setDateOfBirth(LocalDate.of(1995, 3, 18));
        request.setStreetCode(1);
        request.setBuilding("10");
        request.setExtension("2");
        request.setApartment("121");

        try {
            PersonCheckDAO dao = DAOProvider.getInstance().getPersonCheckDAO();
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
