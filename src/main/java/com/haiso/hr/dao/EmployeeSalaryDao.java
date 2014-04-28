package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.salary.Salary;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeSalaryDao extends CrudRepository<Salary, Long> {
}
