package com.haiso.hr.dao;

import com.haiso.hr.entity.person.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ff on 4/11/14.
 */
public interface PersonDao extends CrudRepository<Person, Long> {
    public Person findById(long id);
    public List<Person> findByName(String name);
    public Person findByIdCardIdCardNum(String idCardNum);
}
