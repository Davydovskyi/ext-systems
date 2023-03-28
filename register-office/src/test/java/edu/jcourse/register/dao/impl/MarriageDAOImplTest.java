package edu.jcourse.register.dao.impl;

import edu.jcourse.register.dao.DAOProvider;
import edu.jcourse.register.dao.MarriageDAO;
import edu.jcourse.register.domain.MarriageCertificate;
import edu.jcourse.register.view.MarriageRequest;
import org.junit.jupiter.api.Test;

class MarriageDAOImplTest {

    @Test
    void findMarriageCertificate() {
        DAOProvider provider = DAOProvider.getInstance();
        MarriageDAO dao = provider.getMarriageDAO();

        MarriageRequest request = new MarriageRequest();
        request.setMarriageCertificateNumber("1234567");

//        MarriageCertificate marriageCertificate = dao.findMarriageCertificate(request);
//        System.out.println(marriageCertificate);
    }
}