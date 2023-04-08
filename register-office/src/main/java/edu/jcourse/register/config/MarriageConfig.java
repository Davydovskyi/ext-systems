package edu.jcourse.register.config;

import edu.jcourse.register.dao.impl.PersonDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarriageConfig {
    @Bean
    public PersonDAO buildPersonDAO() {
        return new PersonDAO();
    }
}
