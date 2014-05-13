package com.haiso.hr.web.controller;

import com.haiso.commons.utils.DataTransferUtil.DataMappingUtil;
import com.haiso.commons.utils.DataTransferUtil.ExcelReaderV2;
import com.haiso.commons.utils.FileTypeUtil;
import com.haiso.hr.web.validator.MultipartFileValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ff on 5/6/14.RedirectAttributes
 */
@Controller
@RequestMapping("/dataTransfer")
public class DataTransferController {

    @RequestMapping("/import1")
    public String dataTransferImportStep1(Model model) {
        model.addAttribute("msg", "excel文件上传");
        return "/DataTransfer/importUploadFile";
    }

    private MultipartFileValidator multipartFileValidator;

    @PostConstruct
    public void initValidator() {
        multipartFileValidator = new MultipartFileValidator();
        multipartFileValidator.setAllowedContentTypes(new String[]{"application/vnd.ms-excel", "text/plain", "text/csv"});
        multipartFileValidator.setMaxSize(20 * 1024 * 1024);
    }

    @RequestMapping(value = "/import2", method = {RequestMethod.GET, RequestMethod.POST})
    public String uploadFiles(@RequestParam(value = "file", required = false) MultipartFile file,
                              @RequestParam(value = "dataMappingSettings", required = true) String dms,
                              @RequestParam(value = "importTo", required = true) String importTo,
                              HttpServletRequest request, ModelMap model) throws Exception {

        try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            model.addAttribute("msg", e.getMessage());
            return "/DataTransfer/importUploadFile";
        }
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        String fileName = file.getOriginalFilename();
        fileName = new Date().getTime() + "." + FileTypeUtil.getFileExtension(fileName);
        System.out.println(importTo);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            String xlsHashcode = ExcelReaderV2.getSheetTitlesMapHashcode(ExcelReaderV2.getSheet(ExcelReaderV2.createWb(path + "/" + fileName), 0));
            String mapPath = request.getSession().getServletContext().getRealPath("/static/DataMapping/");
            File xmlFile = new File(mapPath + "/" + importTo + ".xml");
            if (xmlFile.exists() ? !(dms.equals("useIfExists") && (DataMappingUtil.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
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
