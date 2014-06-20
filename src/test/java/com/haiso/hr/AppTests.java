package com.haiso.hr;

import com.haiso.commons.utils.PackUtils;
import com.haiso.hr.entity.manage.Menu;
import com.haiso.hr.service.manage.MenuService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

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

    @Autowired
    private MenuService menuService;

    @Test
    public void test() throws Exception {
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
        /*Set<String> set1 = new TreeSet<String>();
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
        System.out.println(set.toArray().toString());*/

//        System.out.println(JsonUtils.toJson(new EntityUtils().traverseEntity("Person", new FieldNode("person"))));

        testAddMenu();

        List<Menu> menu = menuService.getMenuByLevel((short)1);

        System.out.println("menu");

    }

    public void testAddMenu(){
        Menu root = new Menu("Menu", "top Menu", "this is top menu", (short)0);
        Menu m1 = new Menu("m1","","",(short)1);
        Menu m2 = new Menu("m2","","",(short)1);
        Menu m10 = new Menu("m10","","",(short)2);
        Menu m11 = new Menu("m11","","",(short)2);
        Menu m20 = new Menu("m20","","",(short)2);
        Menu m3 = new Menu("m3","","",(short)1);
        Menu m30 = new Menu("m30","","",(short)2);
        Menu m31 = new Menu("m31","","",(short)2);
        root.getSubMenuSet().add(m1);
        root.getSubMenuSet().add(m2);
        root.getSubMenuSet().add(m3);
        m1.getSubMenuSet().add(m10);
        m1.getSubMenuSet().add(m11);
        m2.getSubMenuSet().add(m20);
        m3.getSubMenuSet().add(m30);
        m3.getSubMenuSet().add(m31);
        m1.setParentMenu(root);
        m2.setParentMenu(root);
        m3.setParentMenu(root);
        m10.setParentMenu(m1);
        m11.setParentMenu(m1);
        m20.setParentMenu(m2);
        m30.setParentMenu(m3);
        m31.setParentMenu(m3);

        menuService.addMenu(root);

    }

    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
}
