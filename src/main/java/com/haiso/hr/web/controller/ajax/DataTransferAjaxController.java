package com.haiso.hr.web.controller.ajax;

import com.haiso.base.BaseController;
import com.haiso.commons.utils.JsonUtils;
import com.haiso.hr.web.rest.*;
import com.haiso.hr.web.vo.dataMapping.DataTransferParam;
import com.haiso.commons.model.UploadedFile;
import com.haiso.commons.utils.data.DataMappingUtil;
import com.haiso.commons.utils.data.FileTypeUtil;
import com.haiso.commons.utils.data.excelHelper.ExcelReader;
import com.haiso.hr.service.person.PersonService;
import com.haiso.hr.web.validator.MultipartFileValidator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ff on 5/23/14.
 */
@Controller
@RequestMapping("/ajax")
@SessionAttributes({"dataTransferParam"})
public class DataTransferAjaxController extends BaseController{

    //===================================================================================================================
    private MultipartFileValidator multipartFileValidator = null;
    private UploadedFile uploadedFile = null;

    @PostConstruct
    public void init() {
        multipartFileValidator = new MultipartFileValidator();
        multipartFileValidator.setAllowedContentTypes(new String[]{"application/vnd.ms-excel", "text/plain", "text/csv"});
        multipartFileValidator.setMaxSize(20 * 1024 * 1024);
    }

    @ModelAttribute("dataTransferParam")
    public DataTransferParam getDataTransferParam(){
        return new DataTransferParam();
    }

    //    public UploadFileAjaxController() { }
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    public @ResponseBody
    UploadFileSheetsRest UploadFile(MultipartHttpServletRequest request) {
        Iterator<String> iterator = request.getFileNames();
        MultipartFile file = request.getFile(iterator.next());
        try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            e.printStackTrace();
            return new UploadFileSheetsRest(false, -1, e.getMessage(), null, null);
        }
        String fileName = new Date().getTime() + "." + FileTypeUtil.getFileExtension(file.getOriginalFilename());
        String path = getUploadedFilePath(request);
        File dir = new File(path);
        if(!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        File targetFile = new File(path, fileName);
        try {
            uploadedFile = new UploadedFile(file.getBytes().length, file.getOriginalFilename(), file.getContentType(), file.getBytes());
            FileCopyUtils.copy(uploadedFile.getBytes(), targetFile);
            UploadFileSheetsRest r= new UploadFileSheetsRest(true, 1, "Upload success!", fileName, new ExcelReader().listSheetsName(targetFile.getCanonicalPath()));
            return r;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return new UploadFileSheetsRest(false, -1, "Unknown error.", null, null);
    }

    //===================================================================================================================

    @RequestMapping("/importPrep")
    public @ResponseBody
    CommonsRest importPrepare(@RequestBody String json, HttpServletRequest request, ModelMap model){
        DataTransferParam dataTransferParam = JsonUtils.readValue(json, DataTransferParam.class);
        model.addAttribute(dataTransferParam);
        String path = getUploadedFilePath(request);
        String mapPath = getMappingFilePath(request);
        try {
            File targetFile = new File(path, dataTransferParam.getOrigin());
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), dataTransferParam.getExcelSheetIndex(), dataTransferParam.getExcelTitleIndex());
            File xmlFile = new File(mapPath, dataTransferParam.getDest() + ".xml");
            if (xmlFile.exists() ? !(dataTransferParam.getPreserved().equals("1") && (DataMappingUtil.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                return new CommonsRest(true, 1, "redirect to data mapping", "/dataTransfer/dataMapping");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CommonsRest(true, 2, "redirect to import3","/dataTransfer/import3");
    }
    //===================================================================================================================

    @RequestMapping(value = "/dataMapping", method = {RequestMethod.POST})
    public @ResponseBody
    CommonsRest dataMapping(@RequestBody String json, HttpServletRequest request, @ModelAttribute DataTransferParam dataTransferParam) {
        if(dataTransferParam != null){
            System.out.println(dataTransferParam.getOrigin());
        }else{
            System.out.print("null");
        }

        /*try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> mapping = objectMapper.readValue(json, Map.class);
            Map<String, String> mapFrom = (LinkedHashMap)mapping.get("mapFrom");
            Map<String, String> mapTo = (LinkedHashMap)mapping.get("mapTo");
            String importTo = (String)mapping.get("importTo");
            if (!importTo.isEmpty() && !mapFrom.isEmpty() && !mapTo.isEmpty()) {
                File dir = new File(getMappingFilePath(request));
                if(!dir.exists() || !dir.isDirectory()){
                    dir.mkdirs();
                }
                DataMappingUtil.writeXmlDataMapping(importTo, mapFrom, mapTo, dir.getPath());
                return new CommonsRest(true,1,"success",importTo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonsRest(false,0,e.getMessage(),null);
        }*/
        return new CommonsRest(false,-1,"Unknown error!",null);
    }

    //===================================================================================================================

    @Autowired
    private PersonService personService;

    private Map<String, Integer> mapping = null;

    @RequestMapping("/importing")
    public @ResponseBody
    CommonsRest dataImporting(HttpServletRequest request, HttpServletResponse response){
        return  new CommonsRest();
    }
}
