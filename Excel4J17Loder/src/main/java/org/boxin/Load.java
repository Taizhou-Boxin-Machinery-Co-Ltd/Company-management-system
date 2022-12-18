package org.boxin;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Load {
    public static final Map<String, Map<String, XSSFSheet>> fileXssfListMap = new HashMap<>();
    public static void main(String... args) throws IOException {
        System.out.println("Hello world!");
        for (var fileName : args) {
            sheet(fileName);
        }
    }
    public static void sheet(String fileName) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(fileName)) {
            int numberOfSheets = workbook.getNumberOfSheets();
            final Map<String, XSSFSheet> xssfSheets = new HashMap<>();
            for (int i = 0; i < numberOfSheets; i++) {
                xssfSheets.put(workbook.getSheetName(i), workbook.getSheetAt(i));
            }
            fileXssfListMap.put(fileName, xssfSheets);
        }
    }
    //横向A-Z竖向1-n
    public static void AZ_n(String fileName, String sheetName) {
        XSSFSheet sheet = fileXssfListMap.get(fileName).get(sheetName);
        for (int i = 0; i < 407;i++) {
            
        }
    }

}