package com.haiso.hr.web.controller;

import com.google.common.collect.Lists;
import com.haiso.base.BaseController;
import com.haiso.commons.utils.data.DataMappingUtils;
import com.haiso.commons.utils.data.entityHelper.EntityUtils;
import com.haiso.hr.web.vo.dataMapping.DataTransferParam;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ff on 5/6/14.RedirectAttributes
 */
@Controller
@RequestMapping("/dataTransfer")
@SessionAttributes({"dataTransferParam"})
public class DataTransferController extends BaseController{

    @RequestMapping("/import1")
    public String step1(Model model) {
        model.addAttribute("msg", "");
        return "/DataTransfer/importUploadFile";
    }

    @RequestMapping(value = "/import2", method = {RequestMethod.POST})
    public String uploadFile(HttpServletRequest request, ModelMap model) {
        Integer titleIndex = Integer.valueOf(request.getParameter("titleIndex"));
        Integer sheetIndex = Integer.valueOf(request.getParameter("importFrom"));
        String origin = request.getParameter("dataFile");
        String dest = request.getParameter("importTo");
        Integer dms = Integer.valueOf(request.getParameter("dataMappingSettings"));
        DataTransferParam dataTransferParam = new DataTransferParam(true,origin,dest,sheetIndex,titleIndex,null);
        model.addAttribute("dataTransferParam", dataTransferParam);
        String path = getUploadedFilePath(request);
        File targetFile = new File(path, origin);
        try {
            String xlsHashcode = DataMappingUtils.getDataSourceSheetTitlesMapHashcode((targetFile), sheetIndex, titleIndex);
            String mapPath = getMappingFilePath(request);
            File xmlFile = new File(mapPath, dest + ".xml");
            System.out.print(xmlFile.exists());
            if (xmlFile.exists() ? !(dms == 1 && (DataMappingUtils.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                return redirect("/dataTransfer/dataMapping");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return redirect("/dataTransfer/import3");
    }


    @RequestMapping(value = "/dataMapping", method = {RequestMethod.POST, RequestMethod.GET})
    public String dataMapping(@ModelAttribute DataTransferParam dataTransferParam, HttpServletRequest request, ModelMap model) {
        if(!dataTransferParam.getFileToDB()) {
            return null;//todo
        }
        try {
            Map map = DataMappingUtils.getDataSourceSheetTitlesMap(
                    new File(getUploadedFilePath(request), dataTransferParam.getOrigin()),
                    dataTransferParam.getExcelSheetIndex(),
                    dataTransferParam.getExcelTitleIndex());
            List list = Lists.newArrayList(new EntityUtils().getEntityFields(dataTransferParam.getDest()));
            model.addAttribute("excelTitles", map);
            model.addAttribute("classFields", list);
            model.addAttribute("importTo", dataTransferParam.getDest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "DataTransfer/importDataMapping";
    }

    @RequestMapping(value = "/import3", method = {RequestMethod.POST, RequestMethod.GET})
    public String dataImportStep3(HttpServletRequest request, @ModelAttribute DataTransferParam dataTransferParam, ModelMap model) {
        if(!dataTransferParam.getFileToDB()) {
            return null;//todo
        }
        Map<String, String> mapping = null;
        try{
            mapping = DataMappingUtils.readXmlSimpleDataMapping(getMappingFilePath(request), dataTransferParam.getDest() + ".xml");
        }catch (DocumentException e){
            e.printStackTrace();
        }
        //todo
        model.addAttribute("importTo", dataTransferParam.getDest());
        model.addAttribute("mapping", mapping);
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
