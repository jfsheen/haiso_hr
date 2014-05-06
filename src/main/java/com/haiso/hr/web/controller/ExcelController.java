package com.haiso.hr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExcelController {

    /*@ModelAttribute("titles")
    public List<String> getTitles(HttpServletRequest request){
        List titles = new ArrayList();
        try {
            // 对读取Excel表格标题测试
            String path = request.getSession().getServletContext().getRealPath("static/UploadFiles");
            String file = path + "/pii.xls";
            InputStream is = new FileInputStream(file);
            //ExcelReaderV2 excelReader = new ExcelReaderV2();
            titles = ExcelReaderV2.listSheetTitles(ExcelReaderV2.getSheet(ExcelReaderV2.createWb(file), 0));
            *//*String[] title = excelReader.readExcelTitle(is);
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
                titles.add(s);
            }*//*
        }
            catch (FileNotFoundException e) {
                System.out.println("未找到指定路径的文件!");
                e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }*/
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


    @RequestMapping("/x")
    public String testExcel() {
        return "dataMapping";
    }

//    public String printWelcome(ModelMap model) {
//        model.addAttribute("message", "Hello world!");
//        return "hello";
//    }
//

}