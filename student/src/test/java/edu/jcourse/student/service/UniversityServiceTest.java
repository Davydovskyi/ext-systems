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


    void findUniversities() {
        List<University> universities = service.findUniversities();
        universities.forEach(university -> System.out.println(university.getUniversityId() + ":"
                + university.getUniversityName() + ":" + university.getFaculties().size()));
    }

    void findFaculties() {
        List<Faculty> faculties = service.findFaculties();
        faculties.forEach(faculty -> System.out.println(faculty.getUniversity().getUniversityName()));
    }

    @Test
    void findFaculty() {
        Faculty faculty = service.getFaculty(1L);
        System.out.println(faculty.getUniversity().getUniversityName());
    }

    @Test
    void findAllUniversities() {
        List<University> universities = service.findAllUniversities();
        universities.forEach(university -> System.out.println(university.getUniversityId() + ":"
                + university.getUniversityName() + ":" + university.getFaculties().size()));
    }

    @Test
    void findUniversity() {
        University university = service.getUniversity(1L);
        System.out.println(university.getUniversityName() + ":" + university.getFaculties().size());
    }
}