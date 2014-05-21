package com.haiso.commons.utils.data.fieldHelper;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ff on 5/21/14.
 */
public final class FieldUtil {

    private static Map<String, Class> nameType = null;
    static {
        Map<String, Class> nameType = new LinkedHashMap<String, Class>();
        try {
            nameType.put("String", Class.forName("java.lang.String"));
            nameType.put("Integer", Class.forName("java.lang.Integer"));
            nameType.put("Long", Class.forName("java.lang.Long"));
            nameType.put("Short", Class.forName("java.lang.short"));
            nameType.put("Date", Class.forName("java.util.Date"));
            nameType.put("Boolean", Class.forName("java.lang.Boolean"));
            nameType.put("Byte", Class.forName("java.lang.Byte"));
            nameType.put("Double", Class.forName("java.lang.Double"));
            nameType.put("Float", Class.forName("java.lang.Float"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getType(String name){
        Iterator it = nameType.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            if(entry.getKey().equals(name)){
                return (Class)entry.getValue();
            }
        }
        return null;
    }

    public String getName(Class clazz){
        Iterator it = nameType.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            if(((Class)entry.getValue()).equals(clazz)){
                return (String)entry.getKey();
            }
        }
        return null;
    }
}
