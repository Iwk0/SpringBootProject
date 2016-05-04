package com.social.validation;

import com.social.model.Person;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, Person> {

    @Override
    public void initialize(MatchPassword matchPassword) {

    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        String password = person.getPassword();
        String rawPassword = person.getRawPassword();
        if ((!password.isEmpty() || !rawPassword.isEmpty()) && password.equals(person.getRawPassword())) {
            ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
            person.setPassword(sha.encodePassword(password, ""));
            return true;
        }

        return false;
    }
}