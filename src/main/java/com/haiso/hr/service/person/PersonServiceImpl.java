package com.haiso.hr.service.person;

import com.google.common.collect.Lists;
import com.haiso.hr.dao.PersonDao;
import com.haiso.hr.entity.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Long add(Person person) {
        return personDao.save(person).getId();
    }

    @Override
    @Transactional
    public void remove(Person person) {
        personDao.delete(person.getId());

    }

    @Override
    @Transactional
    public void removePersonById(long id) {
        personDao.delete(id);
    }

    @Override
    public Person findById(long id) {
        return personDao.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>)personDao.findAll();
    }

    @Override
    public List<Person> findByName(String name) {
        return personDao.findByName(name);
    }

    @Override
    public Person findOne() {
//        personDao.findOne();
        return null;
    }

}

