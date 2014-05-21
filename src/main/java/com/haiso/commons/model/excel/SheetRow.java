package com.haiso.commons.model.excel;

import java.util.Set;

/**
 * Created by Heli on 2014/5/21.
 */
public class SheetRow {
    private Integer rowIndex;
    private Set<DataCell> dataCellSet;
    private Integer colNum;
    private Integer colStart;
    private Integer colEnd;

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getColStart() {
        return colStart;
    }

    public void setColStart(Integer colStart) {
        this.colStart = colStart;
    }

    public Integer getColEnd() {
        return colEnd;
    }

    public void setColEnd(Integer colEnd) {
        this.colEnd = colEnd;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Set<DataCell> getDataCellSet() {
        return dataCellSet;
    }

    public void setDataCellSet(Set<DataCell> dataCellSet) {
        this.dataCellSet = dataCellSet;
    }
}
