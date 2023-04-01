package edu.jcourse.student.service;

import edu.jcourse.student.dao.FacultyRepository;
import edu.jcourse.student.dao.UniversityRepository;
import edu.jcourse.student.domain.Faculty;
import edu.jcourse.student.domain.University;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private UniversityRepository universityRepository;
    private FacultyRepository facultyRepository;

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Autowired
    public void setFacultyRepository(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Transactional
    public List<University> findUniversities() {
        return universityRepository.findAll();
    }

    @Transactional
    public List<Faculty> findFaculties() {
        return facultyRepository.findAll();
    }

    @Transactional
    public Faculty getFaculty(Long facultyID) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(facultyID);
        Faculty faculty = optionalFaculty.orElse(null);
        Hibernate.initialize(faculty.getUniversity());
        return faculty;
    }

    @Transactional
    public List<University> findAllUniversities() {
        return universityRepository.findAllUniversities();
    }

    @Transactional
    public University getUniversity(Long universityID) {
        University university = universityRepository.findById(universityID).orElse(null);
        Hibernate.initialize(university.getFaculties());
        return university;
    }
}
