package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.salary.Adjustment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeSalaryAdjustmentDao extends CrudRepository<Adjustment, Integer> {
}
