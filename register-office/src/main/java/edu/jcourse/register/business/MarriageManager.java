package edu.jcourse.register.business;

import edu.jcourse.register.view.MarriageRequest;
import edu.jcourse.register.view.MarriageResponse;

public interface MarriageManager {

    MarriageResponse findMarriageCertificate(MarriageRequest request);
}
