package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.SalaryInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeSalaryInfoDao extends CrudRepository<SalaryInfo, Integer> {
}
