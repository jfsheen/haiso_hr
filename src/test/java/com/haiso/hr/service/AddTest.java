package com.haiso.hr.service;

import com.haiso.hr.entity.Person;
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
@ContextConfiguration("file:src/resources/AppContext.xml")
public class AddTest {

    @Autowired
    private PersonService ps;

    @Before
    public void init() {
        System.out.println("test init");
    }

    @After
    public void end() {
        System.out.println("test end");
    }

    @Test
    public void testAdd() throws Exception {
        Person p = new Person();
        p.setName("网劳务");
        p.setIdcardNum("121231212312312312");
        System.out.println(p.getName());
        ps.addPerson(p);
        System.out.println(ps.getPerson(1).getName());

    }

}
