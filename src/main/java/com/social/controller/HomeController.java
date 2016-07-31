package com.social.controller;

import com.social.repository.PersonRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Log4j
@Controller
public class HomeController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
/*        GoogleCommand google = new GoogleCommand();
        log.info(google.execute());*/
        List s = personRepository.findAllPersons();
        return "index";
    }
}