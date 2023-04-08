package edu.jcourse.register;

import edu.jcourse.register.rest.MarriageController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        MarriageController controller = context.getBean("controller", MarriageController.class);
//        MarriageRequest request = new MarriageRequest();
//        request.setMarriageCertificateNumber("1234567");
//        MarriageResponse response = controller.findMarriageCertificate();
//        System.out.println(response);
    }
}
