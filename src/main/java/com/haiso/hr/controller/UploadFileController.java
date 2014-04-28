package com.haiso.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by ff on 4/27/14.
 */
@Controller
public class UploadFileController {

    @RequestMapping(value = "upload/file", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView uploadImages(@RequestParam(value = "file", required = false) MultipartFile file,
                                     HttpServletRequest request, ModelMap model) {

        ModelAndView mav = new ModelAndView();
        String path = request.getSession().getServletContext().getRealPath("static/UploadFiles");
        String fileName = file.getOriginalFilename();
//          String fileName = new Date().getTime()+".jpg";
//        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //model.addAttribute("fileUrl", request.getContextPath()+"/uploadImages/"+fileName);
        mav.addObject("fileUrl", request.getContextPath() + "/static/UploadFiles/" + fileName);
        mav.setViewName("uploadSuccess");
        return mav;

    }
}
