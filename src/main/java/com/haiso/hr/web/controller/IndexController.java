package com.haiso.hr.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ff on 3/28/14.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("index.html");
        mv.addObject("message", "你好 java ");
        return mv;
    }

}