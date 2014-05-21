package com.haiso.hr.web.controller;

import com.haiso.commons.model.DataTransferParam;
import com.haiso.commons.utils.data.DataMappingUtil;
import com.haiso.commons.utils.json.JsonUtils;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

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

    @RequestMapping(value = "/import2", method = {RequestMethod.POST})
    public String uploadFile(HttpServletRequest request, ModelMap model) {

        Integer titleIndex = 0;
        String fileName = request.getParameter("dataFile");
        Integer sheetIndex = Integer.valueOf(request.getParameter("importFrom"));
        String importTo = request.getParameter("importTo");
        Integer dms = Integer.valueOf(request.getParameter("dataMappingSettings"));
        String path = request.getSession().getServletContext().getRealPath(uploadPath);
        File targetFile = new File(path, fileName);
        try {
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), sheetIndex, titleIndex);
            String mapPath = request.getSession().getServletContext().getRealPath(mapFilePath);
            File xmlFile = new File(mapPath, importTo + ".xml");
            System.out.print(xmlFile.exists());
            if (xmlFile.exists() ? !(dms == USE_IF_EXISTS && (DataMappingUtil.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                model.addAttribute("param", JsonUtils.toJson(new DataTransferParam(true, fileName, importTo, importTo + ".xml", sheetIndex, titleIndex)));
                /*model.addAttribute("importTo", importTo);
                model.addAttribute("fromFile", fileName);
                model.addAttribute("fromSheet", sheetIndex);*/
                return "redirect:/dataTransfer/dataMapping";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("param", new DataTransferParam(true,fileName,importTo,importTo + ".xml",sheetIndex,titleIndex));
        model.addAttribute("importTo", importTo);
        model.addAttribute("fromFile", fileName);
        model.addAttribute("fromSheet", sheetIndex);
        return "redirect:/dataTransfer/import3";
    }

    @RequestMapping("/import3")
    public String dataImportStep3(HttpServletRequest request, ModelMap model) {
        String mapPath = request.getSession().getServletContext().getRealPath(mapFilePath);
        String importTo = request.getParameter("importTo");
        String fileName = request.getParameter("fromFile");
        Integer sheetIndex = Integer.valueOf(request.getParameter("fromSheet"));
        System.out.println("importTo = " + mapPath + "/" + importTo);
        System.out.println("importFrom = " + fileName + "/" + sheetIndex);
        Map<String, String> mapping = null;
        try{
            mapping = DataMappingUtil.readXmlSimpleDataMapping(mapPath, importTo + ".xml");
        }catch (DocumentException e){
            e.printStackTrace();
        }
        //todo
        model.addAttribute("mapping", mapping);
        model.addAttribute("importTo", importTo);
        return "/DataTransfer/doImportData";
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
