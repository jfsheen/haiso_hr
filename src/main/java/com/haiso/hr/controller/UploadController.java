package com.haiso.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ff on 4/27/14.
 */
@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }
}
