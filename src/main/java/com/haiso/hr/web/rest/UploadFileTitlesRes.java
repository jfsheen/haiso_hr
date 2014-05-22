package com.haiso.hr.web.rest;

import com.haiso.commons.model.excel.TitleCell;

import java.util.List;

/**
 * Created by Heli on 2014/5/16.
 */
public class UploadFileTitlesRes {
    private Boolean success;
    private Integer code;
    private String msg;
    private List<TitleCell> content;

    public UploadFileTitlesRes(Boolean success, Integer code, String msg, List<TitleCell> content) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public UploadFileTitlesRes() {
    }

    public List<TitleCell> getContent() {
        return content;
    }

    public void setContent(List<TitleCell> content) {
        this.content = content;
    }

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


}