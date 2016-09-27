package com.social;

import com.social.repository.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public InitializingBean insertDefaultUsers() {
        return new InitializingBean() {

            @Autowired
            private PersonRepository personRepository;

            @Override
            public void afterPropertiesSet() {
                addUser();
            }

            private void addUser() {
                if (personRepository.findByEmail("email") != null) {
                    return;
                }

                ShaPasswordEncoder sha = new ShaPasswordEncoder(256);

                //potrebitel
            }
        };
    }
}