package com.haiso.hr.web.controller;

import com.google.common.collect.Lists;
import com.haiso.commons.utils.DataTransferUtil.DataMappingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ff on 5/5/14.
 */
@Controller
@RequestMapping("/dataTransfer")
public class DataMappingController {

    @ModelAttribute("excelTitles")
    public Map<String, String> getTitles(@RequestParam(value = "importFrom", required = true) String importFrom) {
        try {
            String fileName = importFrom;
            System.out.println(fileName);
//            InputStream is = new FileInputStream(fileName);
//            ExcelReaderV2 excelReader = new ExcelReaderV2();
            return DataMappingUtil.getDatasSourceSheetTitles(fileName, 0, 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ModelAttribute("importTo")
    public String getImportTo(@RequestParam(value = "importTo", required = true) String importTo) {
        return importTo;
    }

    @ModelAttribute("classFields")
    public List<String> getClassFields(@RequestParam(value = "importTo", required = true) String importTo) throws Exception {
        return Lists.newArrayList(DataMappingUtil.getEntityFields(importTo));
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

}
