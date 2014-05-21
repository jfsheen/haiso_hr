package com.haiso.commons.model.excel;

import com.haiso.commons.enumeration.ExcelCellDataType;

/**
 * Created by Heli on 2014/5/17.
 */
public class TitleCell extends DataCell {

    public TitleCell() {
    }

    public TitleCell(Integer rowIndex, Integer colIndex, String name) {
        super(rowIndex, colIndex, ExcelCellDataType.STRING, name);
    }
}
