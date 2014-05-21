package com.haiso.hr.service.person;

import com.haiso.hr.entity.person.Person;

import java.util.List;

/**
 * Created by ff on 4/11/14.
 */
public interface PersonService {

    public void add(Person person);

    public void remove(Person person);

    public void removePersonById(long id);

    public Person findById(long id);

    public List<Person> findAll();

    public Boolean exists(Person person);

    public List<Person> findByName(String name);

    public Boolean exists(Person person);

    public Person findOne();

}
