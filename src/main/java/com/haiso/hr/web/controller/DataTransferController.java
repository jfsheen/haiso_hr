package com.haiso.hr.web.controller;

import com.google.common.collect.Lists;
import com.haiso.commons.model.DataTransferParam;
import com.haiso.commons.utils.data.DataMappingUtil;
import com.haiso.commons.utils.json.JsonUtil;
import com.haiso.commons.utils.param.PackUtil;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
@SessionAttributes(types = {DataTransferParam.class})
public class DataTransferController {

    private final int USE_IF_EXISTS = 1;
    private final int REMAPPING_ANYWAY = 0;
    private String uploadPath = "/static/UploadFiles/";
    private String mapFilePath = "/static/DataMapping/";
    private String path = null;
    private String mapPath = null;

    private DataTransferParam<Integer> dataTransferParam = null;

    @RequestMapping("/import1")
    public String step1(Model model) {
        model.addAttribute("msg", "");
        return "/DataTransfer/importUploadFile";
    }

    @RequestMapping(value = "/import2", method = {RequestMethod.POST})
    public String uploadFile(HttpServletRequest request, ModelMap model) {
        if(null != dataTransferParam){
            System.out.println("old="+dataTransferParam.getOrigin()+dataTransferParam.getPreserved());
            dataTransferParam = null;
        }
        dataTransferParam = JsonUtil.readValue(request.getParameter("ipdata"), DataTransferParam.class);
        dataTransferParam.setPreserved(Integer.valueOf(request.getParameter("dms")));
        System.out.println("fresh="+dataTransferParam.getOrigin()+dataTransferParam.getPreserved());
        path = request.getSession().getServletContext().getRealPath(uploadPath);
        mapPath = request.getSession().getServletContext().getRealPath(mapFilePath);
        File targetFile = new File(path, dataTransferParam.getOrigin());
        try {
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), dataTransferParam.getExcelSheetIndex(), dataTransferParam.getExcelTitleIndex());
            File xmlFile = new File(mapPath, dataTransferParam.getDest() + ".xml");
            System.out.print(xmlFile.exists());
            if (xmlFile.exists() ? !(dataTransferParam.getPreserved().intValue() == USE_IF_EXISTS && (DataMappingUtil.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                return "redirect:/dataTransfer/dataMapping";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dataTransfer/import3";
    }

    @RequestMapping(value = "/dataMapping", method = {RequestMethod.POST, RequestMethod.GET})
    public String dataMapping(ModelMap model) {
        if(!dataTransferParam.getFileToDB()) {
            return null;//todo
        }
        try {
            Map map = DataMappingUtil.getDataSourceSheetTitlesMap(
                    new File(path, dataTransferParam.getOrigin()),
                    dataTransferParam.getExcelSheetIndex(),
                    dataTransferParam.getExcelTitleIndex());
            List list = Lists.newArrayList(DataMappingUtil.getEntityFields(dataTransferParam.getDest()));
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
    public String dataImportStep3(HttpServletRequest request, ModelMap model) {
        if(!dataTransferParam.getFileToDB()) {
            return null;//todo
        }
        Map<String, String> mapping = null;
        try{
            mapping = DataMappingUtil.readXmlSimpleDataMapping(mapPath, dataTransferParam.getDest() + ".xml");
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
