package com.haiso.hr.service;

import com.haiso.hr.entity.person.Person;

/**
 * Created by ff on 4/11/14.
 */
public interface PersonService {
    public void addPerson(Person person);

    public Person getPerson(long id);
}
