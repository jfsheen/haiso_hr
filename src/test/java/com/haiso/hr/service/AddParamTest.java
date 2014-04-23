package com.haiso.hr.service;

import com.haiso.hr.entity.param.EmplSequence;
import com.haiso.hr.entity.param.EmplStatus;
import com.haiso.hr.service.param.ParamService;
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
public class AddParamTest {

    @Autowired
    private ParamService ps;


    @Before
    public void init() {
        System.out.println("test init");
    }

    @After
    public void end() {
        System.out.println("test end");
    }

    @Test
    public void testAddParam() throws Exception {
        EmplStatus es = new EmplStatus();
        es.setpKey("1");
        es.setpValue("employed");
        ps.addParam(es);
        EmplSequence seq = new EmplSequence();
        seq.setpKey("1");
        seq.setpValue("主任");
        seq.setSeq(100);
        ps.addParam(seq);

    }

}
