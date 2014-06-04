package com.haiso.hr;

import com.google.common.collect.Sets;
import com.haiso.commons.utils.PackUtils;
import com.haiso.commons.utils.data.entityHelper.EntityUtils;
import com.haiso.commons.utils.data.entityHelper.FieldUtils;
import com.haiso.hr.entity.person.Person;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import sun.reflect.generics.tree.Tree;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/ApplicationContext.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testXmlMapping() throws Exception {
       /* File file = new File("E:\\idea\\haiso_hr\\target\\haiso.hr\\static\\UploadFiles\\11.xlsx");
        ExcelReader excelReader = new ExcelReader();
        System.out.println(excelReader.getContentType(file));*/
        //http://localhost:8080/dataTransfer/import3?param=H4sIAAAAAAAAAKtWSsvMSQ3Jd3FSsiopKk3VUcovykzPzFOyUjI0MTAwN7I0NDU0NzLRq8gpVtJRSkktLgFKBaQWFefnAfm5iQV%2BibmpcCG9itwcoHBqRXJqTnBGamqJZ15KaoWSlQFULCSzJCcVJlYLAIHMcRN9AAAA
        String str = "RN9AAAA";
        String a = PackUtils.Pack(str);
        String b = PackUtils.Unpack(a);
        System.out.println(a + a.length());
        System.out.println(b + b.length());
//        System.out.println(new Constants().getUploadFilePath("/"));

/*        Person person = new Person();
        FieldUtils fu = new FieldUtils();
        fu.setFieldValue(person, "id", new Long(1));
        fu.setFieldValue(person, "name", new String("zhangsan"));
//        fu.setFieldValue(person, "joinPartyDate", new Date("2012-01-01"));
        System.out.println(person.toString());*/
        Set<String> set1 = new TreeSet<String>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        Set<String> set2 = new TreeSet<String>();
        set2.add("a");
        set2.add("c");
        set2.add("e");
        set2.add("2");
        Set set = Sets.newTreeSet(CollectionUtils.union(set1, set2));
        set = Sets.newTreeSet(CollectionUtils.disjunction(set1,set2));
        set = Sets.newTreeSet(CollectionUtils.intersection(set1, set2));
        set = Sets.newTreeSet(CollectionUtils.subtract(set1, set2));
        System.out.println(set.toArray().toString());

        Map<String, String> map1 = new LinkedHashMap<String, String>();
        Map<Integer, String> map2 = new LinkedHashMap<Integer, String>();
        map1.put("a","a1");
        map1.put("b","b1");
        map1.put("c","c1");
        map1.put("d","d1");
        map1.put("e","e1");
        map2.put(1,"2a");
        map2.put(3,"2b");
        map2.put(5,"2c");
        map2.put(7,"2d");
        map2.put(9,"2e");
        String m2 = map2.get(1);
        m2 = map2.get("1");
        System.out.println(map2.get(2));

    }


    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
}
