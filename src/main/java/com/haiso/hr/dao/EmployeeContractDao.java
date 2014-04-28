package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.Contract;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeContractDao extends CrudRepository<Contract, String> {
}
