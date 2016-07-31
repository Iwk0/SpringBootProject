package com.social;

import com.social.model.Person;
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
                if (personRepository.findByEmail("ivomishev@gmail.com") != null) {
                    return;
                }

                ShaPasswordEncoder sha = new ShaPasswordEncoder(256);

                Person person = new Person();
                person.setFirstName("Иво");
                person.setLastName("Мишев");
                person.setEmail("ivomishev@gmail.com");
                person.setPassword(sha.encodePassword("abv123", ""));
                person.setRole(Person.Role.ADMIN);
                person.setStatus(Person.Status.ACTIVE);
                person.setUniqueName("ivo.mishev");
                personRepository.save(person);
            }
        };
    }
}