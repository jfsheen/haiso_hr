package com.haiso.commons.utils.data.excelHelper;

import com.google.common.collect.Lists;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;

/**
 * Created by Heli on 2014/5/21.
 */
public final class ExcelHelper {

    private static String[] contentTypes = {
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "application/vnd.ms-excel"
    };

    private static Boolean isExcelFile(String filePath) throws IOException {
        return Lists.newArrayList(contentTypes).contains(new Tika().detect(filePath));
    }

    private static Boolean isExcelFile(File file) throws IOException {
        return Lists.newArrayList(contentTypes).contains(new Tika().detect(file));
    }
}
