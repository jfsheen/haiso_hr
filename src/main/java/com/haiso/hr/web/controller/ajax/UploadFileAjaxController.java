package com.haiso.hr.web.controller.ajax;

import com.haiso.commons.utils.FileTypeUtil;
import com.haiso.hr.web.validator.MultipartFileValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ff on 5/14/14.
 */

@Controller
@RequestMapping("/ajax")
public class UploadFileAjaxController {

    private MultipartFileValidator multipartFileValidator;

    @PostConstruct
    public void initValidator() {
        multipartFileValidator = new MultipartFileValidator();
        multipartFileValidator.setAllowedContentTypes(new String[]{"application/vnd.ms-excel", "text/plain", "text/csv"});
        multipartFileValidator.setMaxSize(20 * 1024 * 1024);
    }

    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST})
    public
    @ResponseBody
    String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                      HttpServletRequest request, ModelMap model) {
        try {
            multipartFileValidator.validate(file);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
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
            System.out.println("Upload succeed!");
            return "Upload succeed!";
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Unknown error!");
        return "Unknown error!";
    }
}
