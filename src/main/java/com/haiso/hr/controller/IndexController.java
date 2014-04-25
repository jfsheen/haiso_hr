package com.haiso.hr.controller;


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
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "你好 java ");
        System.out.println("hello java");
        return mv;
    }

}