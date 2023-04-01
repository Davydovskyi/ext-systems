package edu.jcourse.student.service;

import edu.jcourse.student.domain.Faculty;
import edu.jcourse.student.domain.University;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
class UniversityServiceTest {

    @Autowired
    private UniversityService service;

    @Test
    void findUniversities() {
        List<University> universities = service.findUniversities();
        universities.forEach(university -> System.out.println(university.getUniversityId() + ":"
                + university.getUniversityName() + ":" + university.getFaculties().size()));
    }

    @Test
    void findFaculties() {
        List<Faculty> faculties = service.findFaculties();
        faculties.forEach(faculty -> System.out.println(faculty.getUniversity().getUniversityName()));
    }
}