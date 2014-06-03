package com.haiso.commons.utils.data.excelHelper;

//import static net.yeah.likun_zhang.util.Debug.printf;
//import net.yeah.likun_zhang.util.Debug;

import com.haiso.commons.enumeration.ExcelCellDataType;
import com.haiso.commons.model.excel.DataCell;
import com.haiso.commons.utils.data.DatePattern;
import com.haiso.commons.model.excel.TitleCell;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.Tika;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ff on 5/5/14.
 */
public class ExcelReader {



    /**
     * 创建工作簿对象
     *
     * @param filePath
     * @return
     * @throws IOException
     * @date 2013-5-11
     */

    private Workbook createWb(String filePath) throws IOException {
        if (StringUtils.isBlank(filePath)) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        System.out.println(getContentType(new File(filePath)));
        return createWb(new File(filePath));
    }

    private Workbook createWb(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        if (getContentType(file).equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return new XSSFWorkbook(new FileInputStream(file));
        } else if (getContentType(file).equals("application/vnd.ms-excel")) {
            return new HSSFWorkbook(new FileInputStream(file));
        } else {
            throw new IllegalArgumentException("Wrong file type.");
        }
    }

    private Workbook createWb(FileInputStream is) throws IOException{
        if(is == null){
            throw new IllegalArgumentException("Illegal arguments!");
        }
        System.out.println(getContentType(is));
        if (getContentType(is).equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return new XSSFWorkbook(is);
        } else if (getContentType(is).equals("application/vnd.ms-excel")) {
            return new HSSFWorkbook(is);
        } else {
            throw new IllegalArgumentException("Wrong file type.");
        }
    }

    public String getContentType(FileInputStream is) throws IOException{
        return new Tika().detect(is);
    }
    public String getContentType(File file) throws IOException {
        return new Tika().detect(file);
    }

    private Sheet getSheet(Workbook wb, String sheetName) {
        return wb.getSheet(sheetName);
    }

    private Sheet getSheet(Workbook wb, int index) {
        return wb.getSheetAt(index);
    }

    private List<Sheet> listSheets(Workbook wb) {
        List<Sheet> sheets = new ArrayList<Sheet>();
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            sheets.add(wb.getSheetAt(i));
        }
        return sheets;
    }

    private List<Sheet> listSheets(String filePath) throws IOException {
        return listSheets(createWb(filePath));
    }

    private List<Sheet> listSheets(File file) throws IOException {
        return listSheets(createWb(file));
    }


    public List<String> listSheetsName(String filePath) throws IOException {
        List<String> list = new ArrayList<String>();
        for (Sheet s : listSheets(filePath)) {
            list.add(s.getSheetName());
        }
        return list;
    }

    public List<String> listSheetsName(File file) throws IOException {
        List<String> list = new ArrayList<String>();
        for (Sheet s : listSheets(file)) {
            list.add(s.getSheetName());
        }
        return list;
    }

    /*private List<Object[]> listFromSheet(Sheet sheet) {
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
    }*/

    private Map<String, String> listSheetTitles(Sheet sheet, Integer titleRowIndex) {
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

    public Map<String, String> listSheetTitles(String filePath, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return listSheetTitles(getSheet(createWb(filePath), sheetIndex), titleRowIndex);
    }

    public Map<String, String> listSheetTitles(File file, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return listSheetTitles(getSheet(createWb(file), sheetIndex), titleRowIndex);
    }

    private List<TitleCell> listSheetTitlesModel(Sheet sheet, Integer titleRowIndex) {
        List<TitleCell> titles = new ArrayList<TitleCell>();
        Row row = sheet.getRow(titleRowIndex);
        for (int i = row.getFirstCellNum(); i <= row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell == null || cell.toString().equals("")) continue;
            TitleCell titleCellModel = getTitleModelFromCell(cell);
            titles.add(titleCellModel);
        }
        return titles;
    }

    public List<TitleCell> listSheetTitlesModel(String filePath, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return listSheetTitlesModel(getSheet(createWb(filePath), sheetIndex), titleRowIndex);
    }

    public List<TitleCell> listSheetTitlesModel(File file, Integer sheetIndex, Integer titleRowIndex) throws IOException {
        return listSheetTitlesModel(getSheet(createWb(file), sheetIndex), titleRowIndex);
    }

    public Map<Integer, DataCell> fetchDataRowByMapping(File file, Integer sheetIndex, Integer rowIndex, List cols) throws IOException {
        return fetchDataRowByMapping(createWb(file), sheetIndex, rowIndex, cols);
    }
    private Map<Integer, DataCell> fetchDataRowByMapping(Workbook wb, Integer sheetIndex, Integer rowIndex, List cols) throws IOException{
        if(rowIndex < 0 || sheetIndex > wb.getNumberOfSheets() || cols.size() == 0){
            throw new IllegalArgumentException("Illegal arguments!");
        }
        Sheet sheet = getSheet(wb, sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if(row == null)
            return null;
        Map<Integer, DataCell> dataMap = new LinkedHashMap<Integer, DataCell>();
        Iterator<Object> it = cols.iterator();
        while(it.hasNext()){
            Object col = it.next();
            Integer iCol = (col instanceof String) ? Integer.valueOf((String)col) : (Integer)col;
            Cell cell = row.getCell(iCol);
            if(cell == null) continue;
            DataCell dataCell = getDataCellModelFromCell(row.getCell(iCol));
            if(!(dataCell.getValue() == null || dataCell.getValue().toString().isEmpty())){
                dataMap.put(iCol, dataCell);
            }
        }
        return dataMap;
    }

    /**
     * 获取单元格内文本信息
     *
     * @param cell
     * @return
     * @date 2013-5-8
     */

    private TitleCell getTitleModelFromCell(Cell cell) {
        return new TitleCell(cell.getRowIndex(), cell.getColumnIndex(), (String) getDataCellModelFromCell(cell).getValue());
    }

    public DataCell getDataCellModelFromCell(Cell cell) {
        if (cell == null) {
            System.out.println("Cell is NULL.");
            return null;
        }
        DataCell dataCell = new DataCell();
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:    // 数字
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    dataCell.setCellDataType(ExcelCellDataType.DATE);// 如果是日期类型
                    dataCell.setValue(new DateTime(cell.getDateCellValue()).toDate());
                } else {
                    dataCell.setCellDataType(ExcelCellDataType.DOUBLE);
                    dataCell.setValue(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING:
                dataCell.setCellDataType(ExcelCellDataType.STRING);// 字符串
                dataCell.setValue(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:    // 公式
                // 用数字方式获取公式结果，根据值判断是否为日期类型
                double numericValue = cell.getNumericCellValue();
                if (HSSFDateUtil.isValidExcelDate(numericValue)) {    // 如果是日期类型
                    dataCell.setCellDataType(ExcelCellDataType.DATE);
                    dataCell.setValue(new DateTime(cell.getDateCellValue()).toDate());
                } else {
                    dataCell.setCellDataType(ExcelCellDataType.DOUBLE);
                    dataCell.setValue(numericValue);
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:            // Boolean
                dataCell.setCellDataType(ExcelCellDataType.BOOLEAN);
                dataCell.setValue(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:                // 空白
                dataCell.setCellDataType(ExcelCellDataType.EMPTY);
                dataCell.setValue(StringUtils.EMPTY);//ExcelConstants.EMPTY_CELL_VALUE ;
                break;
            case Cell.CELL_TYPE_ERROR:                // Error，返回错误码
                dataCell.setCellDataType(ExcelCellDataType.ERROR);
                dataCell.setValue(null);
                break;
            default:
                dataCell.setCellDataType(ExcelCellDataType.EMPTY);
                dataCell.setValue(StringUtils.EMPTY);
                break;
        }
        dataCell.setRowIndex(cell.getRowIndex());
        dataCell.setColIndex(cell.getColumnIndex());
        return dataCell;
    }

    public Map.Entry<String, String> getValueFromCell(Cell cell) {
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