package com.haiso.hr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/import2", method = {RequestMethod.POST})
    @ResponseBody
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file,
                             HttpServletRequest request, ModelMap model) {
        /*try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            return e.getMessage();
        }
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        String fileName = new Date().getTime() + "." + FileTypeUtil.getFileExtension(file.getOriginalFilename());
        File targetFile = new File(path, fileName);
        try {
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            return "Upload succeed!";
        }catch(IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        return "";
    }

    /*@RequestMapping(value = "/import2a", method = {RequestMethod.GET, RequestMethod.POST})
    public String analysisFile(@RequestParam(value = "file", required = false) MultipartFile file,
                              @RequestParam(value = "dataMappingSettings", required = true) String dms,
                              @RequestParam(value = "importTo", required = true) String importTo,
                              HttpServletRequest request, ModelMap model) {

        try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            model.addAttribute("msg", e.getMessage());
            return "/DataTransfer/importUploadFile";
        }
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        String fileName = new Date().getTime() + "." + FileTypeUtil.getFileExtension(file.getOriginalFilename());
        System.out.println(importTo);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((path + "/" + fileName), 0, 0);
            String mapPath = request.getSession().getServletContext().getRealPath("/static/DataMapping/");
            File xmlFile = new File(mapPath, importTo + ".xml");
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
    }*/

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
