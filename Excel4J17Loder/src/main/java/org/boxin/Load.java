package org.boxin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Load {
//    public static final Map<String, Map<String, XSSFSheet>> fileXssfListMap = new HashMap<>();
//    public static final List<XSS> xssList = new ArrayList<>();
//    public static final List<XSSxy> XSS_XY = new ArrayList<>();
    public static final List<Record> records = new ArrayList<>();
    public static void main(String... args) throws IOException {
        System.out.println("Hello world!");
        for (var fileName : args) {
            sheet(fileName);
        }
//        xssList.forEach(Load::AZ_n);
    }
    public static void sheet(String fileName) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(fileName)) {
            int numberOfSheets = workbook.getNumberOfSheets();
//            final Map<String, XSSFSheet> xssfSheets = new HashMap<>();
            for (int i = 0; i < numberOfSheets; i++) {
                final String sheetName = workbook.getSheetName(i);
                final XSSFSheet sheet = workbook.getSheetAt(i);
                int rowN = sheet.getLastRowNum();
                for (int j = 0; j < rowN; j++) {
                    XSSFRow row = sheet.getRow(j);
                    if (row != null) {
                        int cellN = row.getLastCellNum();
                        for (int k = 0; k < cellN; k++) {
                            XSSFCell cell = row.getCell(k);
                            if (cell != null) {
                                String value = String.valueOf(cell.getNumericCellValue());
                                char name = (char) ('A' + cell.getColumnIndex());
                                records.add(new Record(fileName, sheetName, cell.getRowIndex() + 1, String.valueOf(name), value));
                            }
                        }
                    }
                }
//                xssList.add(new XSS(fileName, workbook.getSheetName(i), workbook.getSheetAt(i)));
//                xssfSheets.put(workbook.getSheetName(i), workbook.getSheetAt(i));
            }
//            fileXssfListMap.put(fileName, xssfSheets);
        }
    }
    //横向A-Z竖向1-n
    public record Record(String fileName, String sheetName, int x, String y, String value) {
        @Override
        public String toString() {
            return String.format("fileName:%s, sheetName:%s, <%d,%s>, %s", fileName, sheetName, x, y, value);
        }
    }
}