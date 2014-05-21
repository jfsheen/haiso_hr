package com.haiso.commons.model.excel;

import java.util.Set;

/**
 * Created by Heli on 2014/5/21.
 */
public class ExcelSheet{
    private Integer sheetIndex;
    private String sheetName;
    private Set<SheetRow> sheetRowSet;
    private Integer rowNum;
    private Integer titleRowIndexStart;
    private Integer titleRowIndexEnd;
    private Integer dataRowIndexStart;
    private Integer dataRowIndexEnd;

    public Integer getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Set<SheetRow> getSheetRowSet() {
        return sheetRowSet;
    }

    public void setSheetRowSet(Set<SheetRow> sheetRowSet) {
        this.sheetRowSet = sheetRowSet;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getTitleRowIndexStart() {
        return titleRowIndexStart;
    }

    public void setTitleRowIndexStart(Integer titleRowIndexStart) {
        this.titleRowIndexStart = titleRowIndexStart;
    }

    public Integer getTitleRowIndexEnd() {
        return titleRowIndexEnd;
    }

    public void setTitleRowIndexEnd(Integer titleRowIndexEnd) {
        this.titleRowIndexEnd = titleRowIndexEnd;
    }

    public Integer getDataRowIndexStart() {
        return dataRowIndexStart;
    }

    public void setDataRowIndexStart(Integer dataRowIndexStart) {
        this.dataRowIndexStart = dataRowIndexStart;
    }

    public Integer getDataRowIndexEnd() {
        return dataRowIndexEnd;
    }

    public void setDataRowIndexEnd(Integer dataRowIndexEnd) {
        this.dataRowIndexEnd = dataRowIndexEnd;
    }
}
