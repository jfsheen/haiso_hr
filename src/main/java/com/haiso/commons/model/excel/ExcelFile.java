package com.haiso.commons.model.excel;

import com.google.common.collect.Lists;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Set;

/**
 * Created by Heli on 2014/5/18.
 */
public class ExcelFile {

    private String fileName;
    private String fileType;
    private Integer sheetNum;
    private String filePath;
    private Set<String> sheetNameSet;
    private Set<ExcelSheet> sheetSet;

    public ExcelFile() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(Integer sheetNum) {
        this.sheetNum = sheetNum;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Set<String> getSheetNameSet() {
        return sheetNameSet;
    }

    public void setSheetNameSet(Set<String> sheetNameSet) {
        this.sheetNameSet = sheetNameSet;
    }

    public Set<ExcelSheet> getSheetSet() {
        return sheetSet;
    }

    public void setSheetSet(Set<ExcelSheet> sheetSet) {
        this.sheetSet = sheetSet;
    }
}
