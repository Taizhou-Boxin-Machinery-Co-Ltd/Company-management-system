package org.boxin;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Load {
    private static final Map<String, Map<String, XSSFSheet>> fileXssfListMap = new HashMap<>();
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
}