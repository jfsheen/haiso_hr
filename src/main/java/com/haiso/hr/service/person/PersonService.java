package com.haiso.hr.service.person;

import com.haiso.hr.entity.person.Person;

import java.util.List;

/**
 * Created by ff on 4/11/14.
 */
public interface PersonService {

    public void addPerson(Person person);

    public void removePerson(Person person);

    public void removePersonById(long id);

    public Person findPersonById(long id);

    public List<Person> findAll();

    public void importPersons(String filePath);

}
