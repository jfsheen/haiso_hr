package com.haiso.hr.service;

import com.haiso.hr.entity.employee.Employee;
import com.haiso.hr.entity.param.EmplLevel;
import com.haiso.hr.entity.param.EmplSequence;
import com.haiso.hr.entity.param.EmplStatus;
import com.haiso.hr.entity.person.IdCard;
import com.haiso.hr.entity.person.Person;
import com.haiso.hr.service.employee.EmployeeService;
import com.haiso.hr.service.param.ParamService;
import com.haiso.hr.service.person.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Created by ff on 4/11/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/ApplicationContext.xml")
public class AddTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private ParamService paramService;

    @Autowired
    private EmployeeService employeeService;

    @Before
    public void init() throws Exception {
        System.out.println("test init");
        testAddParam();
    }

    @After
    public void end() {
        System.out.println("test end");
    }

    @Test
    public void testAddPerson() throws Exception {
        Person p = new Person();
        IdCard id = new IdCard();
        p.setName("www");
        id.setIdCardNum("121231212312312312");
        p.setIdCard(id);
        Employee e = new Employee();
        e.setPerson(p);
        //e.setEmplLevel(lvl);
        //personService.addPerson(p);
        employeeService.addEmployee(e);
        System.out.println(personService.getPerson(1).getName());
        System.out.println(personService.getPerson(1).getEmployee().getEmplSn());
        System.out.println(employeeService.getEmployee("em-sn00001").getPerson().getName());

    }

    public void testAddParam() throws Exception {
        EmplStatus es = new EmplStatus();
        es.setpKey("1");
        es.setpValue("employed");
        paramService.addParam(es);
        EmplSequence seq = new EmplSequence();
        seq.setpKey("1");
        seq.setpValue("主任");
        paramService.addParam(seq);
        EmplLevel lvl = new EmplLevel();
        lvl.setpKey("1");
        lvl.setpValue("15");
        paramService.addParam(lvl);
    }

}
