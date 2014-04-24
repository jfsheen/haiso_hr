package com.haiso.hr.service.employee;

import com.haiso.hr.dao.EmployeeDao;
import com.haiso.hr.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ff on 4/11/14.
 */

@Service("employeeService")
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);

    }

    @Override
    public Employee getEmployee(String emplSn) {
        Employee p = (Employee) employeeDao.findOne(emplSn);
        return p;
    }
}
