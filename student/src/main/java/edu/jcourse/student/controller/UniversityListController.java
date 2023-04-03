package edu.jcourse.student.controller;

import edu.jcourse.student.domain.University;
import edu.jcourse.student.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(path = "/universityList")
public class UniversityListController {

    private UniversityService service;

    @Autowired
    public void setService(UniversityService service) {
        this.service = service;
    }

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String findUniversities(Model model) {
        List<University> universities = service.findUniversities();
        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("universities", universities);
        return "universityList";
    }
}
