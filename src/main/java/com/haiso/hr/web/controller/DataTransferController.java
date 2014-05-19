package com.haiso.hr.web.controller;

import com.haiso.commons.utils.DataTransfer.DataMappingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by ff on 5/6/14.RedirectAttributes
 */
@Controller
@RequestMapping("/dataTransfer")
public class DataTransferController {

    @RequestMapping("/import1")
    public String dataTransferImportStep1(Model model) {
        model.addAttribute("msg", "");
        return "/DataTransfer/importUploadFile";
    }

    private static final int USE_IF_EXISTS = 1;
    private static final int REMAPPING_ANYWAY = 0;

    @RequestMapping(value = "/import2", method = {RequestMethod.POST})
    public String uploadFile(HttpServletRequest request, ModelMap model) {

        Integer titleIndex = 0;
        String fileName = request.getParameter("dataFile");
        Integer sheetIndex = Integer.valueOf(request.getParameter("importFrom"));
        String importTo = request.getParameter("importTo");
        Integer dms = Integer.valueOf(request.getParameter("dataMappingSettings"));
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        File targetFile = new File(path, fileName);
        try {
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), sheetIndex, titleIndex);
            String mapPath = request.getSession().getServletContext().getRealPath("/static/DataMapping/");
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
        return "/DataTransfer/importDataDo";
    }

    @RequestMapping("/import3")
    public String dataTransferImportStep3(Model model) {
        model.addAttribute("msg", "step 3");
        return "ImportAndExport/importUploadFile";
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
