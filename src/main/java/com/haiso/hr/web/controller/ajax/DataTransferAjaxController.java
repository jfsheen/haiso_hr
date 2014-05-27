package com.haiso.hr.web.controller.ajax;

import com.google.common.collect.Lists;
import com.haiso.base.BaseController;
import com.haiso.commons.constant.CommonsConstant;
import com.haiso.commons.model.excel.DataCell;
import com.haiso.hr.entity.person.Person;
import com.haiso.hr.web.enumeration.HrEntityEnum;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by ff on 5/23/14.
 */
@Controller
@RequestMapping("/ajax")
@SessionAttributes({"dataTransferParam"})
public class DataTransferAjaxController extends BaseController{

    DataTransferParam dataTransferParam = null;

    //    public UploadFileAjaxController() { }
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    public @ResponseBody
    UploadFileSheetsRest UploadFile(MultipartHttpServletRequest request) {
        MultipartFileValidator multipartFileValidator = new MultipartFileValidator();
        multipartFileValidator.setAllowedContentTypes(new String[]{"application/vnd.ms-excel", "text/plain", "text/csv"});
        multipartFileValidator.setMaxSize(20 * 1024 * 1024);

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
            UploadedFile uploadedFile = new UploadedFile(file.getBytes().length, file.getOriginalFilename(), file.getContentType(), file.getBytes());
            FileCopyUtils.copy(uploadedFile.getBytes(), targetFile);
            return new UploadFileSheetsRest(true, 1, "Upload success!", fileName, new ExcelReader().listSheetsName(targetFile.getCanonicalPath()));
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
        /*dataTransferParam = JsonUtils.readValue(json, DataTransferParam.class);
//        model.addAttribute("dataTransferParam", dataTransferParam);
        String param = PackUtil.Pack(JsonUtils.toJson(dataTransferParam));
        String path = getUploadedFilePath(request);
        String mapPath = getMappingFilePath(request);
        try {
            File targetFile = new File(path, dataTransferParam.getOrigin());
            String xlsHashcode = DataMappingUtil.getDataSourceSheetTitlesMapHashcode((targetFile), dataTransferParam.getExcelSheetIndex(), dataTransferParam.getExcelTitleIndex());
            File xmlFile = new File(mapPath, dataTransferParam.getDest() + ".xml");
            if (xmlFile.exists() ? !(dataTransferParam.getPreserved().equals("1") && (DataMappingUtil.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                return new CommonsRest(true, 1, param, "/dataTransfer/dataMapping");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return new CommonsRest(true, 2, "unknown error","/dataTransfer/import3");
    }
    //====================@RequestBody String json, ===============================================================================================

    @RequestMapping(value = "/dataMapping", method = {RequestMethod.POST})
    public @ResponseBody
    CommonsRest dataMapping(HttpServletRequest request,
                            @ModelAttribute DataTransferParam dataTransferParam,
                            @RequestBody String json) {
        if(dataTransferParam != null){
            System.out.println(dataTransferParam.getOrigin());
            try {
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
            }
        }
        return new CommonsRest(false,-1,"Unknown error!",null);
    }

    //===================================================================================================================

    @Autowired
    private PersonService personService;
/*
    private Map<String, Integer> mapping = null;*/

    @RequestMapping("/doImport")
    public @ResponseBody
    CommonsRest dataImporting(@ModelAttribute DataTransferParam dataTransferParam,
                              HttpServletRequest request, HttpServletResponse response){
        if(dataTransferParam != null){
            Map<String, String> mapping = null;
            try{
                mapping = DataMappingUtil.readXmlSimpleDataMapping(getMappingFilePath(request), dataTransferParam.getDest() + ".xml");
                //todo {remove NULL-value list elements}
                List<String> nnCols = new ArrayList<String>();
                Iterator<String> it = Lists.newArrayList(mapping.values()).iterator();
                while(it.hasNext()){
                    String s = it.next();
                    if(!(s.isEmpty() || s == null)){
                        nnCols.add(s);
                    }
                }
                ExcelReader excelReader = new ExcelReader();
                Map<Integer, DataCell> data = null;
                int i = 1;
                int l = 0;
                File file = new File(getUploadedFilePath(request), dataTransferParam.getOrigin());
                while(l < CommonsConstant.MAX_NUM_OF_EMPTY_ROWS) {
                    data = excelReader.fetchDataRowByMapping(file,
                            dataTransferParam.getExcelSheetIndex(),
                            dataTransferParam.getExcelTitleIndex() + i,
                            nnCols);
                    i++;
                    if(data == null){
                        l++;
                        continue;
                    }
                    else
                        l = 0;

                    HrEntityEnum entity = HrEntityEnum.valueOf(dataTransferParam.getDest());

                    switch (entity){
                        case Person:
                            Person person = new Person();

                            break;
                        case Employee:
                            break;
                    }


                }
            } catch(Exception e){
                e.printStackTrace();
            }

        }
        return new CommonsRest(false,-1,"Unknown error!",null);
    }
}
