package com.haiso.hr.service;

import com.haiso.hr.utils.IdCardUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by ff on 4/17/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/resources/AppContext.xml")
public class DigestTest {

    @Before
    public void init() {
        System.out.println("test init");
    }

    @After
    public void end() {
        System.out.println("test end");
    }

    @Test
    public void testDigest() {
        String d1 = "1";
        String d2 = "1 ";
        String sha1 = DigestUtils.sha1Hex(d1);
        String sha2 = DigestUtils.sha1Hex(d2);

        System.out.println("sha1=" + sha1 + " LENGTH=" + sha1.length());
        System.out.println("sha2=" + sha2 + " LENGTH=" + sha2.length());

        System.out.println("the end");

        if (IdCardUtils.validateCard("42070319890908291X"))
            System.out.println("908 = true");
        String d = "42070319890829291";
        String[] s = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "x"};
        for (int i = 0; i < s.length; i++) {
            String id = "";
            id = d + s[i];
            if (IdCardUtils.validateCard(id))
                System.out.println(id + "true");
            else
                System.out.println(id + "false");

        }
        if (IdCardUtils.validateCard("42070319890829291X"))
            System.out.println("829 = true");
    }
}
