package com.social.validation;

import com.social.model.Person;
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
        return person.getPassword().equals(person.getRawPassword());
    }
}