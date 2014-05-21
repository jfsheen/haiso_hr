package com.haiso.hr.entity.datamapping;

import javax.persistence.*;

/**
 * Created by Heli on 2014/5/16.
 */
@Entity
@DiscriminatorValue("SHEET")
public class ExcelSheetModel extends ExcelWorkbookModel {


    private Integer index;
    private String sheetName;
    private String entityName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ExcelWorkbookModel wb;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public ExcelWorkbookModel getWb() {
        return wb;
    }

    public void setWb(ExcelWorkbookModel wb) {
        this.wb = wb;
    }
}
