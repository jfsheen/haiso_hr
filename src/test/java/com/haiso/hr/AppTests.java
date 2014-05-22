package com.haiso.hr;

import com.haiso.commons.utils.data.DataMappingUtil;
import com.haiso.commons.utils.param.PackUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.pack200.Pack200Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

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
        String a = PackUtil.Pack(str);
        String b = PackUtil.Unpack(a);
        System.out.println(a + a.length());
        System.out.println(b + b.length());
    }


    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
}
