package com.haiso.hr.web.controller;

import com.haiso.hr.entity.employee.salary.Salary;
import com.haiso.hr.utils.DataTransferUtil.DataMappingConfig;
import com.haiso.hr.utils.DataTransferUtil.ExcelReaderV2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ff on 5/5/14.
 */
@Controller
public class DataMappingController {

    @ModelAttribute("exceltitles")
    public Map<String, String> getTitles(HttpServletRequest request) {
        Map<String, String> titles = new HashMap<String, String>();
        try {
            // 对读取Excel表格标题测试
            String path = request.getSession().getServletContext().getRealPath("static/UploadFiles");
            String file = path + "/pi.xlsx";
            InputStream is = new FileInputStream(file);
            //ExcelReaderV2 excelReader = new ExcelReaderV2();
            titles = ExcelReaderV2.listSheetTitles(ExcelReaderV2.getSheet(ExcelReaderV2.createWb(file), 0));
            /*String[] title = excelReader.readExcelTitle(is);
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
                titles.add(s);
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }

    @ModelAttribute("classfields")
    public Map<String, String> getClassFields() {
        return DataMappingConfig.getEntityFields(Salary.class);
    }
/*

    try {
        // 对读取Excel表格标题测试
        String path = request.getSession().getServletContext().getRealPath("static/UploadFiles");
        String file = path + "/pi.xls";
        InputStream is = new FileInputStream(file);
        ExcelReader excelReader = new ExcelReader();
        String[] title = excelReader.readExcelTitle(is);
        System.out.println("获得Excel表格的标题:");
        for (String s : title) {
            System.out.print(s + " ");
        }

        // 对读取Excel表格内容测试
        InputStream is2 = new FileInputStream(file);
        Map<Integer, String> map = excelReader.readExcelContent(is2);
        System.out.println("获得Excel表格的内容:");
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(map.get(i));
        }

    } catch (FileNotFoundException e) {
        System.out.println("未找到指定路径的文件!");
        e.printStackTrace();
    }
*/


    @RequestMapping("/dm")
    public String testExcel() {
        return "dataMapping";
    }

//    public String printWelcome(ModelMap model) {
//        model.addAttribute("message", "Hello world!");
//        return "hello";
//    }
//

}
