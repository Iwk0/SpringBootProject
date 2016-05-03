package com.social.controller;

import com.social.model.Person;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Log4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            log.error("User cannot login");
            model.addAttribute("error", error);
        }

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String index(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
        model.addAttribute("person", person);

        if (result.hasErrors()) {
            log.error("Missing attribute in person object");
            return "redirect:/login";
        }

        return "redirect:/login";
    }
}