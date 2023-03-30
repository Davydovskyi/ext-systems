package edu.jcourse.student.rest;

import edu.jcourse.student.service.StudentService;
import edu.jcourse.student.view.StudentRequest;
import edu.jcourse.student.view.StudentResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentRepository(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<StudentResponse> getStudentInfo(StudentRequest request) {
        return studentService.getStudentIngo(request);
    }
}
