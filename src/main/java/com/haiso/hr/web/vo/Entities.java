package com.haiso.hr.web.vo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ff on 6/4/14.
 */
public final class Entities {
    public static Map<String, String> person = new LinkedHashMap<String, String>();
    public static Map<String, String> idCard = new LinkedHashMap<String, String>();
    static {
        person.put("","");

        idCard.put("idCardNum","");
        idCard.put("idName","");
        idCard.put("idGender","");
        idCard.put("idAddress","");
        idCard.put("idEthnic","");
        idCard.put("idCardPicPath","");
        idCard.put("idIssueAuth","");
        idCard.put("idValidStart","");
        idCard.put("idValidUntil","");

    }
}
