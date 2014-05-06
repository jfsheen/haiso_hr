package com.haiso.hr.utils.DataTransferUtil;

/**
 * Created by ff on 5/5/14.
 */
public enum DatePattern {
    LOCALE_ZH_DATE("yyyy-MM-dd HH:mm:ss");

    private String datePattern;

    private DatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public String getValue() {
        return this.datePattern;
    }
}
