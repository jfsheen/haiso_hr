package com.haiso.hr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ff on 5/6/14.
 */
@Controller
@RequestMapping("/dataTransfer")
public class DataTransferController {

    @RequestMapping("/Step3")
    public String dataTransferStep3(Model model) {
        model.addAttribute("msg", "step 3");
        return "dataTransfer";
    }

    @RequestMapping("/Step4")
    public String dataTransferStep4(Model model) {
        model.addAttribute("msg", "step 4");
        return "dataTransfer";
    }
}
