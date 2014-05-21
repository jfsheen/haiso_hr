package com.haiso.hr.web.rest;

/**
 * Created by ff on 5/21/14.
 */
public class DataImportingRes {
    private Boolean success;
    private Integer code;
    private String msg;

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

    public DataImportingRes(Boolean success, Integer code, String msg) {

        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public DataImportingRes() {

    }
}
