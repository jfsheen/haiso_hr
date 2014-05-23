package com.haiso.hr.web.vo.dataMapping;

/**
 * Created by Heli on 2014/5/21.
 */
public class DataTransferParam{
    private Boolean fileToDB;
    private String origin;
    private String dest;
    private Integer excelSheetIndex;
    private Integer excelTitleIndex;
    private String preserved = null;

    public String getPreserved() {
        return preserved;
    }

    public void setPreserved(String preserved) {
        this.preserved = preserved;
    }

    public Boolean getFileToDB() {
        return fileToDB;
    }

    public void setFileToDB(Boolean fileToDB) {
        this.fileToDB = fileToDB;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Integer getExcelSheetIndex() {
        return excelSheetIndex;
    }

    public void setExcelSheetIndex(Integer excelSheetIndex) {
        this.excelSheetIndex = excelSheetIndex;
    }

    public Integer getExcelTitleIndex() {
        return excelTitleIndex;
    }

    public void setExcelTitleIndex(Integer excelTitleIndex) {
        this.excelTitleIndex = excelTitleIndex;
    }

    public DataTransferParam(Boolean fileToDB, String origin, String dest, String mapName, Integer excelSheetIndex, Integer excelTitleIndex) {

        this.fileToDB = fileToDB;
        this.origin = origin;
        this.dest = dest;
        this.excelSheetIndex = excelSheetIndex;
        this.excelTitleIndex = excelTitleIndex;
    }

    public DataTransferParam(Boolean fileToDB, String origin, String dest, Integer excelSheetIndex, Integer excelTitleIndex, String preserved) {
        this.fileToDB = fileToDB;
        this.origin = origin;
        this.dest = dest;
        this.excelSheetIndex = excelSheetIndex;
        this.excelTitleIndex = excelTitleIndex;
        this.preserved = preserved;
    }

    public DataTransferParam() {
    }

}
