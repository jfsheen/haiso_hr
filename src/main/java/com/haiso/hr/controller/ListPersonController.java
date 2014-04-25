package com.haiso.hr.controller;

import com.haiso.hr.entity.person.IdCard;
import com.haiso.hr.entity.person.Person;
import com.haiso.hr.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ff on 4/25/14.
 */

@Controller

public class ListPersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/list")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {

        Person person = new Person();
        person.setName("lisi");
        IdCard idCard = new IdCard();
        idCard.setIdCardNum("11111111111111111");
        person.setIdCard(idCard);
        personService.addPerson(person);
        List<Person> persons = personService.findAll();
        return new ModelAndView("list", "persons", persons);
    }

}
