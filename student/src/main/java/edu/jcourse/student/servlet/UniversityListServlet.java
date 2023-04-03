package edu.jcourse.student.servlet;

import edu.jcourse.student.domain.University;
import edu.jcourse.student.service.UniversityService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "UniversityListServlet", urlPatterns = {"/universityList"})
public class UniversityListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //integration servlet and spring

        UniversityService service = webApplicationContext.getBean(UniversityService.class);
        List<University> universities = service.findUniversities();

        req.setAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        req.setAttribute("universities", universities);

//        getServletContext().getRequestDispatcher("/universityList.jsp").forward(req, resp);
        getServletContext().getRequestDispatcher("/universityList_jstl.jsp").forward(req, resp);
    }
}
