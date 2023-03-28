package edu.jcourse.register.dao;

import edu.jcourse.register.domain.MarriageCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageDAO extends JpaRepository<MarriageCertificate, Long> {
}
