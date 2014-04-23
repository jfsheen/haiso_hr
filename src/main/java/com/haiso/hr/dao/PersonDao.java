package com.haiso.hr.dao;

import com.haiso.hr.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/11/14.
 */
public interface PersonDao extends CrudRepository<Person, Integer> {
}
