package com.haiso.hr.dao;

import com.haiso.hr.entity.event.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeEventDao extends CrudRepository<Event, Long> {
}
