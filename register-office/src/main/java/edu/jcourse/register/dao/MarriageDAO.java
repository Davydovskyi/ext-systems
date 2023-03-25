package edu.jcourse.register.dao;

import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;

public interface MarriageDAO {

    MarriageCertificate findMarriageCertificate(MarriageRequest request);

}
