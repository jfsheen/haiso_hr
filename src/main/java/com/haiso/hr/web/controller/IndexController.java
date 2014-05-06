package com.haiso.hr.web.controller;


import com.haiso.hr.entity.person.Person;
import com.haiso.hr.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ff on 3/28/14.
 */

@Controller
public class IndexController {

    @Autowired
    private PersonService personService;

    @ModelAttribute("persons")
    public List<Person> getPerson() {
        List<Person> persons = personService.findAll();
        return persons;
    }

    @RequestMapping("/")
    public String listPersons() {
        return "list";
    }


}