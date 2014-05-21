package com.haiso.hr.web.rest;

import java.util.List;

/**
 * Created by Heli on 2014/5/17.
 */
public class UploadFileSheetsRes {
    private Boolean success;
    private Integer code;
    private String msg;
    private String filename;
    private List<String> content;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public UploadFileSheetsRes(Boolean success, Integer code, String msg, String filename, List<String> content) {

        this.success = success;
        this.code = code;
        this.msg = msg;
        this.filename = filename;
        this.content = content;
    }

    public UploadFileSheetsRes() {

    }
}
