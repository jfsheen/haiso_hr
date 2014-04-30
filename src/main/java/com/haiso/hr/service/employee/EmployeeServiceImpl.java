package com.haiso.hr.service.employee;

import com.haiso.hr.dao.EmployeeDao;
import com.haiso.hr.entity.employee.Employee;
import com.haiso.hr.entity.person.Person;
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
    public boolean entry(Person person) {
        return false;
    }

    @Override
    public boolean leave(Employee employee) {
        return false;
    }

    @Override
    public int importEmployeeSalary(String filePath) {
        return 0;
    }

    @Override
    public String exportEmployeeSalary() {
        return null;
    }

    @Override
    public int importEmployeeInfo(String filePath) {
        return 0;
    }

    @Override
    public String exportEmployeeInfo() {
        return null;
    }

    @Override
    public int listMatchedEmployee() {
        return 0;
    }

    @Override
    public boolean adjustEmployeeSalary() {
        return false;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);

    }

    @Override
    public Employee findEmployeeBySn(String emplSn) {
        return employeeDao.findOne(emplSn);
    }
}
