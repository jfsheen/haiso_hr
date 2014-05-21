package com.haiso.hr.web.controller.ajax;

import com.haiso.commons.utils.data.excelHelper.ExcelReader;
import com.haiso.commons.utils.data.FileTypeUtil;
import com.haiso.hr.web.rest.UploadFileSheetsRes;
import com.haiso.hr.web.validator.MultipartFileValidator;
import com.haiso.hr.web.vo.UploadedFile;
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

    private MultipartFileValidator multipartFileValidator = null;
    private UploadedFile uploadedFile = null;
    private ExcelReader excelReader = null;
    @PostConstruct
    public void init() {
        multipartFileValidator = new MultipartFileValidator();
        multipartFileValidator.setAllowedContentTypes(new String[]{"application/vnd.ms-excel", "text/plain", "text/csv"});
        multipartFileValidator.setMaxSize(20 * 1024 * 1024);

        excelReader = new ExcelReader();
    }

    public UploadFileAjaxController() { }

    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    public @ResponseBody
    UploadFileSheetsRes UploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> iterator = request.getFileNames();
        MultipartFile file = request.getFile(iterator.next());
        try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new UploadFileSheetsRes(false, -1, e.getMessage(), null, null);
        }
        String path = request.getSession().getServletContext().getRealPath("/static/UploadFiles/");
        String fileName = new Date().getTime() + "." + FileTypeUtil.getFileExtension(file.getOriginalFilename());
        File dir = new File(path);
        if(!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        File targetFile = new File(path, fileName);
        try {
            uploadedFile = new UploadedFile(file.getBytes().length, file.getOriginalFilename(), file.getContentType(), file.getBytes());
            FileCopyUtils.copy(uploadedFile.getBytes(), targetFile);
            System.out.println("Upload success");
            return new UploadFileSheetsRes(true, 1, "Upload success!", fileName, excelReader.listSheetsName(targetFile.getCanonicalPath()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
