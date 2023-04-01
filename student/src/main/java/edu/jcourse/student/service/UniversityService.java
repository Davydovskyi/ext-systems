package edu.jcourse.student.service;

import edu.jcourse.student.dao.UniversityRepository;
import edu.jcourse.student.domain.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversityService {

    private UniversityRepository universityRepository;

    @Autowired
    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Transactional
    public List<University> findUniversities() {
        return universityRepository.findAll();
    }
}
