package com.haiso.hr.web.controller.ajax;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by ff on 5/7/14.
 */

@Controller
@RequestMapping("/ajax")
public class DataMappingAjaxController {

    @RequestMapping("/dataMapping")
    @ResponseBody
    public String generateDataMappingXML(@RequestBody String json) {
/*        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String json = req.getParameter("json").toString();*/
        System.out.println(json);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> mapping = objectMapper.readValue(json, Map.class);
            Iterator iter = mapping.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                System.out.println(key + ":" + val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
