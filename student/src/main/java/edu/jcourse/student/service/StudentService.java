package edu.jcourse.student.service;

import edu.jcourse.student.dao.StudentRepository;
import edu.jcourse.student.domain.Student;
import edu.jcourse.student.domain.StudentDocument;
import edu.jcourse.student.view.StudentRequest;
import edu.jcourse.student.view.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponse> getStudentIngo(StudentRequest request) {
        List<Student> students = studentRepository.findStudent(request.getLastName(), request.getFirstName(),
                request.getMiddleName(), request.getDateOfBirth(), request.getPassportSeries(),
                request.getPassportNumber(), request.getPassportDate());
        if (students.isEmpty()) {
            return Collections.emptyList();
        }

        List<StudentDocument> documents = students.get(0).getDocuments();
        return documents.stream().map(this::getResponse).collect(Collectors.toList());
    }

    private StudentResponse getResponse(StudentDocument document) {
        StudentResponse response = new StudentResponse();
        response.setDocumentNumber(document.getDocumentNumber());
        response.setFacultyName(document.getFaculty().getFacultyName());
        response.setUniversityName(document.getFaculty().getUniversity().getUniversityName());
        response.setDocumentDate(document.getDocumentDate());
        response.setExpiredDate(document.getExpiredDate());
        response.setEducationForm(document.getEducationForm().toString());
        return response;
    }
}
