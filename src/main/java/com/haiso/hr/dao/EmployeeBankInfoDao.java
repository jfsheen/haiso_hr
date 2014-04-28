package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.BankInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeeBankInfoDao extends CrudRepository<BankInfo, Integer> {
}
