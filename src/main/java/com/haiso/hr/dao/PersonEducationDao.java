package com.haiso.hr.dao;

import com.haiso.hr.entity.person.Education;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface PersonEducationDao extends CrudRepository<Education, Integer> {
}
