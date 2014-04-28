package com.haiso.hr.dao;

import com.haiso.hr.entity.employee.PostTransaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ff on 4/28/14.
 */
public interface EmployeePostTransactionDao extends CrudRepository<PostTransaction, Integer> {
}
