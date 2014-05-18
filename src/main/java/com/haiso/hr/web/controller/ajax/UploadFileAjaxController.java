package com.haiso.hr.web.controller.ajax;

import com.haiso.commons.utils.DataTransfer.ExcelHelper.ExcelReader;
import com.haiso.commons.utils.FileTypeUtil;
import com.haiso.hr.web.rest.UploadFileSheetsReturn;
import com.haiso.hr.web.validator.MultipartFileValidator;
import com.haiso.hr.web.vo.UploadFileModel;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by ff on 5/14/14.
 */

@Controller
@RequestMapping("/ajax")
public class UploadFileAjaxController {

    private MultipartFileValidator multipartFileValidator;
    private UploadFileModel uploadFileModel;
    private ExcelReader excelReader;
    @PostConstruct
    public void initValidator() {
        multipartFileValidator = new MultipartFileValidator();
        multipartFileValidator.setAllowedContentTypes(new String[]{"application/vnd.ms-excel", "text/plain", "text/csv"});
        multipartFileValidator.setMaxSize(20 * 1024 * 1024);
    }

    public UploadFileAjaxController() {
        uploadFileModel = new UploadFileModel();
        excelReader = new ExcelReader();
    }
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    public
    @ResponseBody
    UploadFileSheetsReturn UploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> iterator = request.getFileNames();
        MultipartFile file = request.getFile(iterator.next());
        try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new UploadFileSheetsReturn(false, -1, e.getMessage(), null, null);
        }
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        String fileName = new Date().getTime() + "." + FileTypeUtil.getFileExtension(file.getOriginalFilename());
        File targetFile = new File(path, fileName);
        try {
            uploadFileModel.setLength(file.getBytes().length);
            uploadFileModel.setBytes(file.getBytes());
            uploadFileModel.setName(file.getOriginalFilename());
            uploadFileModel.setContentType(file.getContentType());
            /*if (!targetFile.exists()) {
                    targetFile.mkdirs();
            }*/
            FileCopyUtils.copy(uploadFileModel.getBytes(), targetFile);
            System.out.println("Upload success");
            return new UploadFileSheetsReturn(true, 1, "success", fileName, excelReader.listSheetsName(targetFile.getCanonicalPath()));
//            return new UploadFileTitlesReturn(true,1,"success",excelReader.listSheetTitlesModel(targetFile.getCanonicalPath(),0,0));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
