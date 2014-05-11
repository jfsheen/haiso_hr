package com.haiso.commons.exception;

/**
 * Created by ff on 5/9/14.
 */
@SuppressWarnings("serial")
public class ContentTypeNotSupportException extends RuntimeException {

    public ContentTypeNotSupportException() {
        // TODO Auto-generated constructor stub
    }

    public ContentTypeNotSupportException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ContentTypeNotSupportException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public ContentTypeNotSupportException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ContentTypeNotSupportException(String message, Throwable cause,
                                          boolean enableSuppression, boolean writableStackTrace) {
        //super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public ContentTypeNotSupportException(String string, Object object,
                                          String string2) {
        super(string + object + string2);
    }

}
