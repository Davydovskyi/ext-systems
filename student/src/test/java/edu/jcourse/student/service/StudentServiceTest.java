package edu.jcourse.student.service;

import edu.jcourse.student.rest.StudentController;
import edu.jcourse.student.view.StudentRequest;
import edu.jcourse.student.view.StudentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
class StudentServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTest.class);

    @Autowired
    private StudentController studentController;

    @Test
    void studentInfo() {
        StudentRequest request = new StudentRequest();
        request.setLastName("Last");
        request.setFirstName("First");
        request.setMiddleName("Middle");
        request.setDateOfBirth(LocalDate.of(2000, 4, 12));
        request.setPassportSeries("1111");
        request.setPassportNumber("222222");
        request.setPassportDate(LocalDate.of(2016, 4, 30));

        List<StudentResponse> studentInfo = studentController.getStudentInfo(request);
        Assertions.assertEquals(1, studentInfo.size());
    }
}