package com.haiso.hr.web.controller.ajax;

import com.haiso.hr.service.manage.MenuService;
import com.haiso.hr.web.rest.CommonsRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ff on 6/17/14.
 */
@Controller
@RequestMapping("/ajax/rl")
public class ResourcesLoadAjaxController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/loadRes")
    public @ResponseBody CommonsRest loadResources(){
        return new CommonsRest(true, 1, "load resources success.",
                menuService.findAll().toString());
    }
}
