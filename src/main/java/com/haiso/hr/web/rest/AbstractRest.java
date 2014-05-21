package com.haiso.hr.web.rest;

import java.util.List;

/**
 * Created by Heli on 2014/5/21.
 */
public abstract class AbstractRest<T> {
    private Boolean success;
    private Integer code;
    private String msg;
    private List<T> content;

    protected AbstractRest(Boolean success, Integer code, String msg, List<T> content) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    protected AbstractRest() {

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

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
