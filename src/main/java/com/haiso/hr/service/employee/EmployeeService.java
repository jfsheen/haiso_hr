package com.haiso.hr.service.employee;

import com.haiso.hr.entity.employee.Employee;
import com.haiso.hr.entity.person.Person;

/**
 * Created by ff on 4/11/14.
 */
public interface EmployeeService {
    public boolean entry(Person person);

    public boolean leave(Employee employee);

    public int importEmployeeSalary(String filePath);

    public String exportEmployeeSalary();

    public int importEmployeeInfo(String filePath);

    public String exportEmployeeInfo();

    public int listMatchedEmployee();

    public boolean adjustEmployeeSalary();

    public void addEmployee(Employee employee);

    public Employee findEmployeeBySn(String emplSn);
}
