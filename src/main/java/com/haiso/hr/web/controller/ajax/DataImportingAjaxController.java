package com.haiso.hr.web.controller.ajax;

import com.haiso.hr.service.person.PersonService;
import com.haiso.hr.web.rest.DataImportingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by ff on 5/21/14.
 */
@Controller
@RequestMapping("/ajax")
public class DataImportingAjaxController {

    @Autowired
    private PersonService personService;

    private Map<String, Integer> mapping = null;

    @RequestMapping("/importing")
    public @ResponseBody DataImportingRes dataImporting(HttpServletRequest request,
                                                        HttpServletResponse response){


        return  new DataImportingRes();
    }

}
