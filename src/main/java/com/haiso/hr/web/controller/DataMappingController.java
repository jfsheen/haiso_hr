package com.haiso.hr.web.controller;

import com.haiso.commons.utils.DataTransferUtil.DataMappingConfig;
import com.haiso.commons.utils.DataTransferUtil.ExcelReaderV2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ff on 5/5/14.
 */
@Controller
@RequestMapping("/dataTransfer")
public class DataMappingController {

    @ModelAttribute("exceltitles")
    public List<String> getTitles(@RequestParam(value = "importFrom", required = true) String fileName) {
//                                  HttpServletRequest request) {
        List<String> titles = new ArrayList<String>();
        try {
            // 对读取Excel表格标题测试
//            String path = request.getSession().getServletContext().getRealPath("static/UploadFiles");
            String file = fileName;
            System.out.println(file);
            InputStream is = new FileInputStream(file);
            //ExcelReaderV2 excelReader = new ExcelReaderV2();
            titles = ExcelReaderV2.listSheetTitles(ExcelReaderV2.getSheet(ExcelReaderV2.createWb(file), 0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }

    @ModelAttribute("classfields")
    public Map<String, String> getClassFields(@RequestParam(value = "importTo", required = true) String clazz) throws Exception {


        return DataMappingConfig.getEntityFields(Class.forName(clazz));
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


    @RequestMapping("/dataMapping")
    public String dataMapping() {
        return "DataTransfer/importDataMapping";
    }

    @RequestMapping("/dm4")
    public String testExcel4() {
        return "DataTransfer/importDataDo";
    }
//    public String printWelcome(ModelMap model) {
//        model.addAttribute("message", "Hello world!");
//        return "hello";
//    }
//

}
