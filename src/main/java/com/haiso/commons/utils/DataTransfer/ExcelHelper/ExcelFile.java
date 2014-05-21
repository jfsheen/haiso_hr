package com.haiso.commons.utils.DataTransfer.ExcelHelper;

import com.google.common.collect.Lists;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Heli on 2014/5/18.
 */
public class ExcelFile extends File {
    public ExcelFile(String pathname) {
        super(pathname);
    }

    public ExcelFile(String parent, String child) {
        super(parent, child);
    }

    public ExcelFile(File parent, String child) {
        super(parent, child);
    }

    public ExcelFile(URI uri) {
        super(uri);
    }

    private Boolean isExcelFile(String filePath) throws IOException {
        String[] contentTypes = {"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-excel"};
        return Lists.newArrayList(contentTypes).contains(new Tika().detect(filePath));
    }

    private Boolean isExcelFile(File file) throws IOException {
        String[] contentTypes = {"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.ms-excel"};
        return Lists.newArrayList(contentTypes).contains(new Tika().detect(file));
    }
}
