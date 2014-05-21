package com.haiso.commons.model.excel;

import com.haiso.commons.enumeration.ExcelCellDataType;

/**
 * Created by Heli on 2014/5/17.
 */
public class DataCell {
    private Integer rowIndex;
    private Integer colIndex;
    private Enum<ExcelCellDataType> cellDataType;
    private Object value;

    public DataCell() {
    }

    public DataCell(Integer rowIndex, Integer colIndex, Enum<ExcelCellDataType> cellDataType, Object value) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.cellDataType = cellDataType;
        this.value = value;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getColIndex() {
        return colIndex;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex;
    }

    public Enum<ExcelCellDataType> getCellDataType() {

        return cellDataType;
    }

    public void setCellDataType(Enum<ExcelCellDataType> cellDataType) {
        this.cellDataType = cellDataType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
