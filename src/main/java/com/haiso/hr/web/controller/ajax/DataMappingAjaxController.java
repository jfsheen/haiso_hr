package com.haiso.hr.web.controller.ajax;

import com.haiso.commons.utils.DataTransferUtil.DataMappingUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ff on 5/7/14.
 */

@Controller
@RequestMapping("/ajax")
public class DataMappingAjaxController {

    @RequestMapping("/dataMapping")
    @ResponseBody
    public String generateDataMappingXML(@RequestBody String json,
                                         HttpServletRequest request) {
/*        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String json = req.getParameter("json").toString();*/
//        System.out.println(json);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> mapping = objectMapper.readValue(json, Map.class);
            Map<String, String> mapFrom = new LinkedHashMap<String, String>();
            Map<String, String> mapTo = new LinkedHashMap<String, String>();
            String importTo = null;
            Iterator iter = mapping.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                Object obj = entry.getValue();
                if (key.equals("importTo")) {
                    importTo = (String) obj;
                } else if (key.equals("mapFrom")) {
                    mapFrom = (LinkedHashMap) obj;
                } else if (key.equals("mapTo")) {
                    mapTo = (LinkedHashMap) obj;
                } else {
                    //todo
                    System.out.println("Map is null.");
                }
            }
            if (!importTo.isEmpty() && !mapFrom.isEmpty() && !mapTo.isEmpty()) {
                DataMappingUtil.writeXmlDataMapping(importTo, mapFrom, mapTo, request.getSession().getServletContext().getRealPath("/static/DataMapping/"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
