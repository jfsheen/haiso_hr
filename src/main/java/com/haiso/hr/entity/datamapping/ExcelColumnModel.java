package com.haiso.hr.entity.datamapping;

import com.haiso.commons.enumeration.ExcelCellDataType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Heli on 2014/5/16.
 */
@Entity
@DiscriminatorValue("COLUMN")
public class ExcelColumnModel extends ExcelWorkbookModel {
    private Integer index;
    private Integer titleIndex;
    private String titleName;
    private Enum<ExcelCellDataType> cellType;
    private String fieldName;

    @ManyToOne
    private ExcelSheetModel sheet;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getTitleIndex() {
        return titleIndex;
    }

    public void setTitleIndex(Integer titleIndex) {
        this.titleIndex = titleIndex;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Enum<ExcelCellDataType> getCellType() {
        return cellType;
    }

    public void setCellType(Enum<ExcelCellDataType> cellType) {
        this.cellType = cellType;
    }

    public ExcelSheetModel getSheet() {
        return sheet;
    }

    public void setSheet(ExcelSheetModel sheet) {
        this.sheet = sheet;
    }
}
