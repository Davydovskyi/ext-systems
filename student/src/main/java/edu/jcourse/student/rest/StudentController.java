package edu.jcourse.student.rest;

import edu.jcourse.student.service.StudentService;
import edu.jcourse.student.view.StudentRequest;
import edu.jcourse.student.view.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentRepository(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<StudentResponse> getStudentInfo(@RequestBody StudentRequest request) {
        return studentService.getStudentInfo(request);
    }

    @GetMapping(path = "/check")
    public String checkAdmin() {
        return "Rest Service is working";
    }

    @GetMapping(path = "/params/{checkID}")
    public String checkParams(@PathVariable("checkID") Long id, @RequestParam("comment") String comment) {
        return id + ":" + comment;
    }

    @PostMapping(path = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadPhoto(@RequestParam("comment") String comment,
                              @RequestParam("photoFile") MultipartFile photo) {
        try (InputStream is = photo.getInputStream()) {
            return "Comment: " + comment + ", Name: " + photo.getName()
                    + "File Name: " + photo.getOriginalFilename()
                    + "Size: " + photo.getSize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
