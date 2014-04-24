package com.haiso.hr.service.employee;

import com.haiso.hr.entity.employee.Employee;

/**
 * Created by ff on 4/11/14.
 */
public interface EmployeeService {

    public void addEmployee(Employee employee);

    public Employee getEmployee(String emplSn);
}
