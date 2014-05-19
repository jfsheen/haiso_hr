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
    public void addPerson(Person person) {

        personDao.save(person);
    }

    @Override
    @Transactional
    public void removePerson(Person person) {
        personDao.delete(person.getId());

    }

    @Override
    @Transactional
    public void removePersonById(long id) {
        personDao.delete(id);
    }

    @Override
    public Person findPersonById(long id) {
        Person person = personDao.findOne(id);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return Lists.newArrayList(personDao.findAll());
    }

    @Override
    public void importPersons(String filePath) {


    }

    @Override
    public Boolean exists(Person person) {
        return null;
    }

    @Override
    public Person findOne() {
//        personDao.findOne();
        return null;
    }

}

