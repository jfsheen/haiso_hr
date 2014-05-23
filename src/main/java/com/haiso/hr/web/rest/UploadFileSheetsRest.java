package com.haiso.hr.web.rest;

import java.util.List;

/**
 * Created by Heli on 2014/5/17.
 */
public class UploadFileSheetsRest extends CommonsRest {

    private List<String> sheets;

    public List<String> getSheets() {
        return sheets;
    }

    public void setSheets(List<String> sheets) {
        this.sheets = sheets;
    }

    public UploadFileSheetsRest(Boolean success, Integer code, String msg, String filename, List<String> sheets) {
        super(success, code, msg, filename);
        this.sheets = sheets;
    }
    public UploadFileSheetsRest() {

    }
}
