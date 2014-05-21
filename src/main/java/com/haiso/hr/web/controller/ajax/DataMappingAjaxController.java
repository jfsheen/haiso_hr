package com.haiso.hr.web.controller.ajax;

import com.haiso.commons.utils.data.DataMappingUtil;
import com.haiso.hr.web.rest.DataMappingRes;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ff on 5/7/14.
 */

@Controller
@RequestMapping("/ajax")
public class DataMappingAjaxController {

    @RequestMapping(value = "/dataMapping", method = {RequestMethod.POST})
    public
    @ResponseBody
    DataMappingRes generateDataMappingXML(@RequestBody String json, HttpServletRequest request) {
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
                File dir = new File(request.getSession().getServletContext().getRealPath("/static/DataMapping/"));
                if(!dir.exists() || !dir.isDirectory()){
                    dir.mkdirs();
                }
                DataMappingUtil.writeXmlDataMapping(importTo, mapFrom, mapTo, dir.getPath());
                return new DataMappingRes(true,1,"success",importTo);

            }
        /*} catch (IOException e) {
            e.printStackTrace();*/
        } catch (Exception e) {
            e.printStackTrace();
            return new DataMappingRes(false,0,e.getMessage(),null);
        }
        return new DataMappingRes(false,-1,"Unknown error!",null);
    }
}
