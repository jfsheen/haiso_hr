package com.haiso.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.Resource;

/**
 * PropertyUtils.java
 * Created by ff on 5/23/14.
 */

public class PropertyUtils extends org.apache.commons.beanutils.PropertyUtils {

    public static Properties readFromResource(Resource resource)
            throws IOException {
        Properties prop = new Properties();
        InputStream ins = null;
        ins = resource.getInputStream();
        if (null != ins) {
            prop.load(ins);
        } else {
            throw new IOException("inputstream of resource is null！");
        }
        return prop;
    }
}