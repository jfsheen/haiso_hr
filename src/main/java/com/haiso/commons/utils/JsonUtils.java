package com.haiso.commons.utils;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Heli on 2014/5/22.
 */
public class JsonUtils {

    static ObjectMapper objectMapper;

    /**
     * @param content    要转换的JavaBean类型
     * @param valueType  原始json字符串数据
     * @return JavaBean对象
     */
    public static <T> T readValue(String content, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param object  JavaBean对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
