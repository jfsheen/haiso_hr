package com.haiso.commons.constant;

/**
 * Created by ff on 5/23/14.
 */
public class CommonsConstant {
    /**
     * 应用的根目录，由spring负责初始化
     * */
    public static String webRoot = "";

    public static String uploadedFilePath = "/static/UploadFiles";
    public static String mappingFilePath = "/static/DataMapping";

    public static Integer MAX_NUM_OF_EMPTY_ROWS = 5;

    public static String GENDER_MALE = "男";
    public static String GENDER_FEMALE = "女";
    public static String MARRIED_TRUE = "已婚";
    public static String MARRIED_FALSE = "未婚";
    public static String EMPLOYED_TRUE = "在职";
    public static String EMPLOYED_FALSE = "离职";
    public static String BOOLEAN_YES = "是";
    public static String BOOLEAN_NO = "否";


    public static String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:MM:SS";

    public static String ENTITY_PACKAGE = "com.haiso.hr.entity";
}
