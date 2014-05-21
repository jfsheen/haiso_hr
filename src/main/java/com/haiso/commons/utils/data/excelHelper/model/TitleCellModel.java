package com.haiso.commons.utils.data.excelHelper.model;

import com.haiso.commons.enumeration.ExcelCellDataType;

/**
 * Created by Heli on 2014/5/17.
 */
public class TitleCellModel extends DataCellModel {

    public TitleCellModel() {
    }

    public TitleCellModel(Integer rowIndex, Integer colIndex, String name) {
        super(rowIndex, colIndex, ExcelCellDataType.STRING, name);
    }
}
