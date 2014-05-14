package com.haiso.commons.utils;

//import static net.yeah.likun_zhang.util.Debug.printf;
//import net.yeah.likun_zhang.util.Debug;

import com.haiso.commons.utils.DataTransferUtil.DatePattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ff on 5/5/14.
 */
public final class ExcelReaderV2 {
    /**
     * 创建工作簿对象
     *
     * @param filePath
     * @return
     * @throws IOException
     * @date 2013-5-11
     */
    public Workbook createWb(String filePath) throws IOException {
        if (StringUtils.isBlank(filePath)) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        if (filePath.trim().toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook(new FileInputStream(filePath));
        } else if (filePath.trim().toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook(new FileInputStream(filePath));
        } else {
            throw new IllegalArgumentException("Wrong file type.");
        }
    }

    public Sheet getSheet(Workbook wb, String sheetName) {
        return wb.getSheet(sheetName);
    }

    public Sheet getSheet(Workbook wb, int index) {
        return wb.getSheetAt(index);
    }

    public List<Sheet> listSheets(Workbook wb) {
        List<Sheet> sheets = new ArrayList<Sheet>();
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            sheets.add(wb.getSheetAt(i));
        }
        return sheets;
    }

    public List<Object[]> listFromSheet(Sheet sheet) {

        int rowTotal = sheet.getPhysicalNumberOfRows();
        System.out.println("total row number: " + rowTotal);

        List<Object[]> list = new ArrayList<Object[]>();
        for (int r = sheet.getFirstRowNum(); r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;
            // 不能用row.getPhysicalNumberOfCells()，可能会有空cell导致索引溢出
            // 使用row.getLastCellNum()至少可以保证索引不溢出，但会有很多Null值，如果使用集合的话，就不说了
            Object[] cells = new Object[row.getLastCellNum()];
            for (int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
                Cell cell = row.getCell(c);
                if (cell == null) continue;
                cells[c] = getValueFromCell(cell);
            }
            list.add(cells);
        }

        return list;
    }

    /*   public Map<String, String> listSheetTitles(Sheet sheet) {
           Map<String, String> titles = new TreeMap<String, String>();
           Row row = sheet.getRow(0);
           for (int i = row.getFirstCellNum(); i <= row.getLastCellNum(); i++) {
               Cell cell = row.getCell(i);
               if (cell == null) continue;
               titles.put(i+"", getValueFromCell(cell));
           }
           return titles;
       }*/
    /*public List<String> listSheetTitles(Sheet sheet) {
        List<String> titles = new ArrayList<String>();
        Row row = sheet.getRow(0);
        for (int i = row.getFirstCellNum(); i <= row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell == null || cell.toString().equals("")) continue;
            titles.add(getValueFromCell(cell).toString());
        }
        return titles;
    }*/

    public Map<String, String> listSheetTitles(Sheet sheet, Integer titleRowIndex) {
        Map<String, String> titles = new LinkedHashMap<String, String>();
        Row row = sheet.getRow(titleRowIndex);
        for (int i = row.getFirstCellNum(); i <= row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell == null || cell.toString().equals("")) continue;
            Map.Entry entry = getValueFromCell(cell);
            String key = (String) entry.getKey();
            key = key.substring(key.indexOf(",") + 1, key.length() - 1);
            titles.put(key, (String) entry.getValue());
        }
        return titles;
    }

    public Map<String, String> listSheetTitles(Sheet sheet) {
        return listSheetTitles(sheet, 0);
    }


    /**
     * 获取单元格内文本信息
     *
     * @param cell
     * @return
     * @date 2013-5-8
     */
    public static Map.Entry<Integer, String> getValueFromCell(Cell cell) {
        if (cell == null) {
            System.out.println("Cell is NULL.");
            return null;
        }
        String value = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:    // 数字
                if (HSSFDateUtil.isCellDateFormatted(cell)) {        // 如果是日期类型
                    value = new SimpleDateFormat(DatePattern.LOCALE_ZH_DATE.getValue()).format(cell.getDateCellValue());
                } else value = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:        // 字符串
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:    // 公式
                // 用数字方式获取公式结果，根据值判断是否为日期类型
                double numericValue = cell.getNumericCellValue();
                if (HSSFDateUtil.isValidExcelDate(numericValue)) {    // 如果是日期类型
                    value = new SimpleDateFormat(DatePattern.LOCALE_ZH_DATE.getValue()).format(cell.getDateCellValue());
                } else value = String.valueOf(numericValue);
                break;
            case Cell.CELL_TYPE_BLANK:                // 空白
                value = null;//ExcelConstants.EMPTY_CELL_VALUE ;
                break;
            case Cell.CELL_TYPE_BOOLEAN:            // Boolean
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:                // Error，返回错误码
                value = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                value = StringUtils.EMPTY;
                break;
        }
        // 使用[]记录坐标
        return new AbstractMap.SimpleImmutableEntry(
                "[" + cell.getRowIndex() + "," + cell.getColumnIndex() + "]", value);

    }
}