package com.haiso.commons.exception;

/**
 * Created by ff on 5/9/14.
 */
public class FileOutOfMaxLengthException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public FileOutOfMaxLengthException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public FileOutOfMaxLengthException(String message, Throwable cause,
                                       boolean enableSuppression, boolean writableStackTrace) {
        //super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public FileOutOfMaxLengthException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public FileOutOfMaxLengthException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public FileOutOfMaxLengthException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public FileOutOfMaxLengthException(String string, Object[] objects,
                                       String string2) {
        super(string + objects[0] + string2);
    }

}
