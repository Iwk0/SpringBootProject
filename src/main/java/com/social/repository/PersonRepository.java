package com.social.repository;

import com.social.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByEmail(String email);
    List<Object> findAllPersons();
}