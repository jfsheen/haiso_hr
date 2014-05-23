package com.haiso.hr.commons;

import org.springframework.web.context.ContextLoader;

/**
 * Created by ff on 5/23/14.
 */
public final class Constants {
    //public final String uploadFilePath = "/static/UploadFiles/";
    //public final String mapFilePath = "/static/DataMapping/";

    public String getUploadFilePath(String uploadFilePath){
        String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(uploadFilePath);
        return path;
    }
}
