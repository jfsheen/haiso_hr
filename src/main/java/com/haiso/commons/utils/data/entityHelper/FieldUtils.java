package com.haiso.commons.utils.data.entityHelper;

import com.haiso.commons.constant.CommonsConstant;
import com.haiso.commons.enumeration.ExcelCellDataType;
import com.haiso.commons.model.excel.DataCell;
import com.haiso.commons.utils.StringUtils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ff on 5/21/14.
 */
public final class FieldUtils {

    /**
     * 获取对象属性赋值
     * @param o
     * @param fieldName 字段别名
     * @return
     */
    public Object getFieldValue(Object o, String fieldName) {
        Object result = null;
        try {
            Field fu = o.getClass().getDeclaredField(fieldName); // 获取对象的属性域
            try {
                fu.setAccessible(true); // 设置对象属性域的访问属性
                result = fu.get(o); // 获取对象属性域的属性值
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Boolean convertCellDataToBoolean(DataCell dc){
        Boolean res = null;
        switch(dc.getCellDataType()){
            case STRING:
                String s = (String)dc.getValue();
                res = s.equals(CommonsConstant.BOOLEAN_YES) ||
                        s.equals(CommonsConstant.GENDER_MALE) ||
                        s.equals(CommonsConstant.EMPLOYED_TRUE) ||
                        s.equals(CommonsConstant.MARRIED_TRUE);
                break;
            case BOOLEAN:
                res = (Boolean)dc.getValue();
                break;
            case DOUBLE:
                Double d = (Double)dc.getValue();
                res = d > 0;
                break;
            default:
                res = null;
                break;
        }
        return res;
    }
    private Date convertCellDataToDate(DataCell dc){
        Date res = null;
        switch(dc.getCellDataType()){
            case STRING:
                try{//todo
                    res = DateTimeFormat.forPattern(CommonsConstant.DATE_TIME_FORMATTER).parseDateTime((String)dc.getValue()).toDate();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case DATE:
                res = new DateTime(dc.getValue()).toDate();
                break;
            case DOUBLE:
                res = new DateTime(Math.round((Double)dc.getValue())).toDate();
                break;
            default:
                res = null;
                break;
        }
        return res;
    }
    private Double convertCellDataToNumeric(DataCell dc){
        Double res = null;
        switch(dc.getCellDataType()){
            case STRING:
                try{
                    res = Double.parseDouble((String)dc.getValue());
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case DATE:
                res = Double.longBitsToDouble(new DateTime(dc.getValue()).getMillis());
                break;
            case DOUBLE:
                res = (Double)dc.getValue();
                break;
            case BOOLEAN:
                res = Double.longBitsToDouble((Boolean)dc.getValue() ? 1 : 0);
                break;
            default:
                res = Double.NaN;
                break;
        }
        return res;
    }

    private String convertCellDataToString(DataCell dc){
        String res = null;
        switch(dc.getCellDataType()){
            case STRING:
                res = (String)dc.getValue();
                break;
            case DATE:
                DateTimeFormatter dtf = DateTimeFormat.forPattern(CommonsConstant.DATE_TIME_FORMATTER);
                res = new DateTime(dc.getValue()).toString(dtf);
                break;
            case DOUBLE:
                res = dc.getValue().toString();
                break;
            case BOOLEAN:
                res = dc.getValue().toString();
                break;
            default:
                res = "";
                break;
        }
        return res;
    }
    public Object setFieldValue(Object o, String fieldName, DataCell val) {
        Object result = null;
        try {
            Field fu = o.getClass().getDeclaredField(fieldName); // 获取对象的属性域
            try {
                fu.setAccessible(true); // 设置对象属性域的访问属性
                String t = fu.getType().getSimpleName();
                if (null != val && !"".equals(val) && !"null".equals(val)) {
                    if ("String".equals(t)) {
                        String v = convertCellDataToString(val); // 设置对象属性域的属性值
                        fu.set(o,v);
                    } else if ("Date".equals(t)) {
                        Date v = convertCellDataToDate(val);
                        fu.set(o,v);
                    } else if ("Integer".equals(t) || "int".equals(t)) {
                        Long v = Math.round(convertCellDataToNumeric(val));//todo
                        fu.set(o,v);
                    } else if ("Long".equalsIgnoreCase(t)) {
                        Long v = Math.round(convertCellDataToNumeric(val));
                        fu.set(o,v);
                    } else if ("Double".equalsIgnoreCase(t)) {
                        Double v = convertCellDataToNumeric(val);
                        fu.set(o,v);
                    } else if ("Boolean".equalsIgnoreCase(t)) {
                        Boolean v = convertCellDataToBoolean(val);
                    } else {
                        System.out.println("Type not support: " + t);
                    }
                }
                result = fu.get(o); // 获取对象属性域的属性值
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 给对象属性赋值
     * @param o
     * @param fieldName
     * @param val
     * @return
     */
    public Object setFieldValue(Object o, String fieldName, Object val) {
        Object result = null;
        try {
            Field fu = o.getClass().getDeclaredField(fieldName); // 获取对象的属性域
            try {
                fu.setAccessible(true); // 设置对象属性域的访问属性
                String t = fu.getType().getSimpleName();
                if (null != val && !"".equals(val) && !"null".equals(val)) {
                    if ("String".equals(t)) {
                        fu.set(o,(String)val); // 设置对象属性域的属性值
                    } else if ("Date".equals(t)) {
                        Date v = null;
                        if(val instanceof Date){
                            v = (Date)val;
                        }else if(val instanceof String){
                            v = new DateTime(val).toDate();
                        }
                        fu.set(o, v);
                    } else if ("Integer".equals(t) || "int".equals(t)) {
                        Integer v = (Integer)val;
                    } else if ("Long".equalsIgnoreCase(t)) {
                        Long v = (Long)val;
                    } else if ("Double".equalsIgnoreCase(t)) {
                        Double v = (Double)val;
                    } else if ("Boolean".equalsIgnoreCase(t)) {
                        Boolean v = (Boolean)val;
                    } else {
                        System.out.println("Type not support: " + t);
                    }
                }
                result = fu.get(o); // 获取对象属性域的属性值
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 取Bean的属性和值对应关系的MAP
     * @param o
     * @return Map
     */
    public Map<String, String> getFieldValueMap(Object o) {
        Class<?> cls = o.getClass();
        Map<String, String> valueMap = new HashMap<String, String>();
        // 取出bean里的所有方法
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            try {
                String fieldType = field.getType().getSimpleName();
                String fieldGetName = parGetName(field.getName());
                if (!checkGetMet(methods, fieldGetName)) {
                    continue;
                }
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});
                Object fieldVal = fieldGetMet.invoke(o, new Object[] {});
                String result = null;
                if ("Date".equals(fieldType)) {
                    result = fmtDate((Date) fieldVal);
                } else {
                    if (null != fieldVal) {
                        result = String.valueOf(fieldVal);
                    }
                }
                valueMap.put(field.getName(), result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valueMap;
    }
    
    /**
     * set属性的值到Bean
     * @param o
     * @param valMap
     */
    public void setFieldValue(Object o, Map<String, Object> valMap) {
        Class<?> cls = o.getClass();

        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            String fieldType = "";
            String fieldValue = "";

            try {
                String fieldSetName = parSetName(field.getName());
                if (!checkSetMet(methods, fieldSetName)) {
                    continue;
                }
                Method fieldSetMet = cls.getMethod(fieldSetName, field.getType());
                fieldType = field.getType().getSimpleName();

                Object obj = valMap.get(field.getName());
                if(obj == null){
                    //System.out.println("#Log "+fieldType+"["+field.getName()+"]"+fieldValue+" 匹配失败. ");
                    continue;
                }else{
                    fieldValue = obj.toString();
                    //System.out.println("#Log "+fieldType+"["+field.getName()+"]"+fieldValue+" 匹配数据. ");
                }

                if (null != fieldValue && !"".equals(fieldValue) && !"null".equals(fieldValue)) {
                    if ("String".equals(fieldType)) {
                        fieldSetMet.invoke(o, fieldValue);
                    } else if ("Date".equals(fieldType)) {
                        Date temp = parseDate(fieldValue);
                        fieldSetMet.invoke(o, temp);
                    } else if ("Integer".equals(fieldType) || "int".equals(fieldType)) {
                        Integer intval = Integer.parseInt(fieldValue);
                        fieldSetMet.invoke(o, intval);
                    } else if ("Long".equalsIgnoreCase(fieldType)) {
                        Long temp = Long.parseLong(fieldValue);
                        fieldSetMet.invoke(o, temp);
                    } else if ("Double".equalsIgnoreCase(fieldType)) {
                        Double temp = Double.parseDouble(fieldValue);
                        fieldSetMet.invoke(o, temp);
                    } else if ("Boolean".equalsIgnoreCase(fieldType)) {
                        Boolean temp = Boolean.parseBoolean(fieldValue);
                        fieldSetMet.invoke(o, temp);
                    } else {
                        System.out.println("not supper type" + fieldType);
                    }
                }
            } catch (Exception e) {
                System.out.println("#Log "+fieldType+"["+field.getName()+"]"+fieldValue+" 匹配异常. ");
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 格式化string为Date
     * @param date
     * @return date
     */
    private Date parseDate(String date) {
        if (!(null == date || "".equals(date))) {
            try {
                String fmtstr = null;
                if (date.indexOf(':') > 0) {
                    fmtstr = "yyyy-MM-dd HH:mm:ss";
                } else {
                    fmtstr = "yyyy-MM-dd";
                }
                SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);
                return sdf.parse(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    /**
     * 日期转化为String
     * @param date
     * @return date string
     */
    private String fmtDate(Date date) {
        if (null == date) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否存在某属性的 set方法
     * @param methods
     * @param fieldSetMet
     * @return boolean
     */
    private boolean checkSetMet(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断是否存在某属性的 get方法
     * @param methods
     * @param fieldGetMet
     * @return boolean
     */
    private boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拼接某属性的 get方法
     * @param fieldName
     * @return String
     */
    private String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }
    
    /**
     * 拼接在某属性的 set方法
     * @param fieldName
     * @return String
     */
    private String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }

}
