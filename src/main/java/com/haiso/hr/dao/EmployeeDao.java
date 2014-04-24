package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/24/14.
 */
public interface EmployeeDao extends CrudRepository<Employee, String> {
}
