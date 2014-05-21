package com.haiso.commons.model;

/**
 * Created by Heli on 2014/5/21.
 */
public class DataTransferParam{
    private Boolean fileToDB;
    private String origin;
    private String dest;
    private String mapName;
    private Integer excelSheetIndex;
    private Integer excelTitleIndex;

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

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
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
        this.mapName = mapName;
        this.excelSheetIndex = excelSheetIndex;
        this.excelTitleIndex = excelTitleIndex;
    }

    public DataTransferParam() {
    }

}
