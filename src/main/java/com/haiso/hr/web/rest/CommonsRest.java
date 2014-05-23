package com.haiso.hr.web.rest;

/**
 * Created by ff on 5/23/14.
 */
public class CommonsRest extends  AbstractRest<String> {

    public CommonsRest(Boolean success, Integer code, String msg, String content) {
        super(success, code, msg, content);
    }

    public CommonsRest() {
    }
}
