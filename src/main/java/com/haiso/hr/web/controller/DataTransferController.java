package com.haiso.hr.web.controller;

import com.haiso.commons.utils.DataTransfer.DataMappingUtil;
<<<<<<< HEAD
import org.dom4j.DocumentException;
=======
>>>>>>> ed70ad83f966fa22b7b98a8085c038396786ee9f
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.servlet.ModelAndView;
=======
>>>>>>> ed70ad83f966fa22b7b98a8085c038396786ee9f

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> ed70ad83f966fa22b7b98a8085c038396786ee9f

/**
 * Created by ff on 5/6/14.RedirectAttributes
 */
@Controller
@RequestMapping("/dataTransfer")
public class DataTransferController {

    private final int USE_IF_EXISTS = 1;
    private final int REMAPPING_ANYWAY = 0;
    private final String uploadPath = "/static/UploadFiles/";
    private final String mapFilePath = "/static/DataMapping/";


    @RequestMapping("/import1")
    public String step1(Model model) {
        model.addAttribute("msg", "");
        return "/DataTransfer/importUploadFile";
    }

<<<<<<< HEAD
=======
    private static final int USE_IF_EXISTS = 1;
    private static final int REMAPPING_ANYWAY = 0;

>>>>>>> ed70ad83f966fa22b7b98a8085c038396786ee9f
    @RequestMapping(value = "/import2", method = {RequestMethod.POST})
    public String uploadFile(HttpServletRequest request, ModelMap model) {

        Integer titleIndex = 0;
        String fileName = request.getParameter("dataFile");
        Integer sheetIndex = Integer.valueOf(request.getParameter("importFrom"));
        String importTo = request.getParameter("importTo");
        Integer dms = Integer.valueOf(request.getParameter("dataMappingSettings"));
<<<<<<< HEAD
        String path = request.getSession().getServletContext().getRealPath(uploadPath);
        File targetFile = new File(path, fileName);
        try {
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), sheetIndex, titleIndex);
            String mapPath = request.getSession().getServletContext().getRealPath(mapFilePath);
=======
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        File targetFile = new File(path, fileName);
        try {
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), sheetIndex, titleIndex);
            String mapPath = request.getSession().getServletContext().getRealPath("/static/DataMapping/");
>>>>>>> ed70ad83f966fa22b7b98a8085c038396786ee9f
            File xmlFile = new File(mapPath, importTo + ".xml");
            System.out.print(xmlFile.exists());
            if (xmlFile.exists() ? !(dms == USE_IF_EXISTS && (DataMappingUtil.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                model.addAttribute("importTo", importTo);
                model.addAttribute("importFrom", path + "/" + fileName);
                return "redirect:/dataTransfer/dataMapping";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        model.addAttribute("importTo", importTo);
        model.addAttribute("importFrom", path + "/" + fileName);
        return "redirect:/dataTransfer/import3";
=======
        return "/DataTransfer/importDataDo";
>>>>>>> ed70ad83f966fa22b7b98a8085c038396786ee9f
    }

    @RequestMapping("/import3")
    public ModelAndView dataImportStep3(HttpServletRequest request) {
        String mapPath = request.getSession().getServletContext().getRealPath(mapFilePath);
        String importTo = request.getParameter("importTo");
        System.out.println("importTo = " + mapPath + "$$$" + importTo);
        importTo = importTo == null ? "Person" : importTo;
        Map<String, Map.Entry<Integer, String>> mapping = null;
        ModelAndView mav = new ModelAndView("DataTransfer/doImportData");
        try{
            mapping = DataMappingUtil.readXmlDataMapping(mapPath, importTo + ".xml");
            //todo
//            mav.
//            model.addAttribute("mapping", mapping);
        }catch (DocumentException e){
            e.printStackTrace();
//            model.addAttribute("mapping", "no map");
        }
        return mav;

    }

    @RequestMapping("/import4")
    public String dataTransferImportStep4(Model model) {
        model.addAttribute("msg", "step 4");
        return "ImportAndExport/importUploadFile";
    }

    @RequestMapping("/export1")
    public String dataTransferExportStep1(Model model) {
        model.addAttribute("msg", "step 1");
        return "ImportAndExport/importUploadFile";
    }

    @RequestMapping("/export2")
    public String dataTransferExportStep2(Model model) {
        model.addAttribute("msg", "step 1");
        return "ImportAndExport/importUploadFile";
    }

    @RequestMapping("/export3")
    public String dataTransferExportStep3(Model model) {
        model.addAttribute("msg", "step 1");
        return "ImportAndExport/importUploadFile";
    }

    @RequestMapping("/export4")
    public String dataTransferExportStep4(Model model) {
        model.addAttribute("msg", "step 1");
        return "ImportAndExport/importUploadFile";
    }
}
