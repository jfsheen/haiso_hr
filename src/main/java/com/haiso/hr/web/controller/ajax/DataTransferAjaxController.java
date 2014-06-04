package com.haiso.hr.web.controller.ajax;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.haiso.base.BaseController;
import com.haiso.commons.constant.CommonsConstant;
import com.haiso.commons.model.excel.DataCell;
import com.haiso.commons.utils.data.DataMappingUtils;
import com.haiso.commons.utils.data.FileTypeUtils;
import com.haiso.commons.utils.data.entityHelper.EntityUtils;
import com.haiso.commons.utils.data.entityHelper.FieldUtils;
import com.haiso.hr.entity.person.IdCard;
import com.haiso.hr.entity.person.Person;
import com.haiso.hr.web.enumeration.HrEntityEnum;
import com.haiso.hr.web.rest.*;
import com.haiso.hr.web.vo.Entities;
import com.haiso.hr.web.vo.dataMapping.DataTransferParam;
import com.haiso.commons.model.UploadedFile;
import com.haiso.commons.utils.data.excelHelper.ExcelReader;
import com.haiso.hr.service.person.PersonService;
import com.haiso.hr.web.validator.MultipartFileValidator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        String fileName = new Date().getTime() + "." + FileTypeUtils.getFileExtension(file.getOriginalFilename());
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

/*    @RequestMapping("/importPrep")
    public @ResponseBody
    CommonsRest importPrepare(@RequestBody String json, HttpServletRequest request, ModelMap model){
        *//*dataTransferParam = JsonUtils.readValue(json, DataTransferParam.class);
//        model.addAttribute("dataTransferParam", dataTransferParam);
        String param = PackUtils.Pack(JsonUtils.toJson(dataTransferParam));
        String path = getUploadedFilePath(request);
        String mapPath = getMappingFilePath(request);
        try {
            File targetFile = new File(path, dataTransferParam.getOrigin());
            String xlsHashcode = DataMappingUtils.getDataSourceSheetTitlesMapHashcode((targetFile), dataTransferParam.getExcelSheetIndex(), dataTransferParam.getExcelTitleIndex());
            File xmlFile = new File(mapPath, dataTransferParam.getDest() + ".xml");
            if (xmlFile.exists() ? !(dataTransferParam.getPreserved().equals("1") && (DataMappingUtils.getXmlDataMappingFromHashcode(xmlFile)).equals(xlsHashcode)) : true) {
                return new CommonsRest(true, 1, param, "/dataTransfer/dataMapping");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*//*
        return new CommonsRest(true, 2, "unknown error","/dataTransfer/import3");
    }*/
    //====================@RequestBody String json, ===============================================================================================

    @RequestMapping(value = "/dataMapping", method = {RequestMethod.POST})
    public @ResponseBody
    CommonsRest dataMapping(HttpServletRequest request,
                            @ModelAttribute DataTransferParam dataTransferParam,
                            @RequestBody String json) {
        if(dataTransferParam != null){
            System.out.println(dataTransferParam.getOrigin());//todo
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
                    DataMappingUtils.writeXmlDataMapping(importTo, mapFrom, mapTo, dir.getPath());
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
        String res = "";
        if(dataTransferParam != null){
            Map<String, String> mapping = null;
            try{
                mapping = DataMappingUtils.readXmlSimpleDataMapping(getMappingFilePath(request), dataTransferParam.getDest() + ".xml");
                //todo {remove NULL-value list elements}
                Iterator<Map.Entry<String, String>> it = mapping.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, String> entry=it.next();
                    if(entry.getValue().isEmpty() || entry.getValue() == null)
                        it.remove();
                }
                ExcelReader excelReader = new ExcelReader();
                int idr = 1;
                int ner = 0;
                File file = new File(getUploadedFilePath(request), dataTransferParam.getOrigin());
                Sheet sheet = excelReader.getSheet(excelReader.createWb(file), dataTransferParam.getExcelSheetIndex());
                while(ner < CommonsConstant.MAX_NUM_OF_EMPTY_ROWS) {
                    Map<String, DataCell> rd = excelReader.fetchDataRowByMapping(sheet,
                            dataTransferParam.getExcelTitleIndex() + idr,
                            Lists.newArrayList(mapping.values()));
                    idr++;
                    if(rd == null || rd.isEmpty()){
                        ner++;
                        continue;
                    }else{
                        ner = 0;
                    }

                    HrEntityEnum entity = HrEntityEnum.valueOf(dataTransferParam.getDest());
                    FieldUtils fieldUtils= new FieldUtils();
                    EntityUtils entityUtils = new EntityUtils();
                    switch (entity){
                        case Person:
                            IdCard idCard = new IdCard();
                            Person person = new Person();
                            Set<String> ids = Sets.newHashSet(Entities.idCard.keySet());
                            Set<String> ps = Sets.newHashSet(CollectionUtils.intersection(mapping.keySet(), ids));
                            Iterator<String> it2 = ps.iterator();
                            while(it2.hasNext()){
                                String fn = it2.next();
                                DataCell dc = rd.get(mapping.get(fn));
                                Object val = fn.equals("idGender") ? dc.getValue().equals(CommonsConstant.GENDER_MALE) : dc.getValue();
                                fieldUtils.setFieldValue(idCard, fn, val);
                            }
                            person.setIdCard(idCard);
                            ps = Sets.newHashSet(CollectionUtils.subtract(mapping.keySet(), ids));
                            it2 = ps.iterator();
                            while(it2.hasNext()){
                                String fn = it2.next();
                                DataCell dc = rd.get(mapping.get(fn));
                                Object val = fn.equals("married") ? dc.getValue().equals(CommonsConstant.MARRIED_TRUE) : dc.getValue();
                                fieldUtils.setFieldValue(idCard, fn, val);
                            }
                            res = person.toString();
//                            personService.add(person);
                            break;
                        case Adjustment:
                            break;
                        case Deduct:
                            break;
                        case EmplInfo:
                            break;
                        case Pay:
                            break;
                        case Salary:
                            break;
                        case Assessment:
                            break;
                        case BankInfo:
                            break;
                        case Contract:
                            break;
                        case Employee:
                            break;
                        case Event:
                            break;
                        case PhysicalExamination:
                            break;
                        case PostTransaction:
                            break;
                        case RewardsPunishment:
                            break;
                        case EmplLevel:
                            break;
                        case EmplSequence:
                            break;
                        case EmplStatus:
                            break;
                        case InsuLocation:
                            break;
                        case Param:
                            break;
                        case BasicInfo:
                            break;
                        case Certificate:
                            break;
                        case Education:
                            break;
                        case IdCard:
                            break;
                        case SocialRelationship:
                            break;
                        case WorkExperience:
                            break;
                        case Department:
                            break;
                        case Log:
                            break;
                        case Position:
                            break;
                    }


                }
            } catch(Exception e){
                e.printStackTrace();
            }

        }
        return new CommonsRest(true,1, res, null);
    }
}
