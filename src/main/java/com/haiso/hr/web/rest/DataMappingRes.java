package com.haiso.hr.web.rest;

/**
 * Created by ff on 5/21/14.
 */
public class DataMappingRes {
    private Boolean success;
    private Integer code;
    private String msg;
    private String mapFile;

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

    public String getMapFile() {
        return mapFile;
    }

    public void setMapFile(String mapFile) {
        this.mapFile = mapFile;
    }

    public DataMappingRes() {

    }

    public DataMappingRes(Boolean success, Integer code, String msg, String mapFile) {

        this.success = success;
        this.code = code;
        this.msg = msg;
        this.mapFile = mapFile;
    }
}
