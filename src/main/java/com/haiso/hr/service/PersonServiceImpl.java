package com.haiso.hr.service;

import com.haiso.hr.dao.PersonDao;
import com.haiso.hr.entity.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ff on 4/11/14.
 */

@Service("personService")
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDao.save(person);
    }

    @Override
    public Person getPerson(long id) {
        Person p = (Person) personDao.findOne(id);
        return p;
    }
}
