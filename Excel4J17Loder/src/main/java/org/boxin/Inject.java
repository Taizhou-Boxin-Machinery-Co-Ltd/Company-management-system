package org.boxin;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.boxin.g4.BXEXCELLexer;
import org.boxin.g4.BXEXCELParser;
import org.boxin.g4.CelVisitor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * @author baka4n
 * @since 用于快速导入excel
 */
public class Inject {
    public static void inject(Map<String, Map<String, Map<Integer, Map<String, Serializable>>>> map) {
        map.forEach((fileName, mapMap) -> {
            try (XSSFWorkbook sheets = new XSSFWorkbook()) {
                mapMap.forEach((sheetName, mapMapMap) -> {
                    XSSFSheet sheet = sheets.createSheet(sheetName);
                    mapMapMap.forEach((x, mapMapMapMap) -> {
                        XSSFRow row = sheet.getRow(x) != null ? sheet.getRow(x) : sheet.createRow(x);
                        mapMapMapMap.forEach((y, serializable) -> {
                            int a = y.charAt(0) - "A".charAt(0);
                            XSSFCell cell = row.getCell(a) != null ?
                                    row.getCell(a) :
                                    row.createCell(a);
                            if (serializable != null) if (serializable instanceof String vaule)
                                cell.setCellValue(vaule);
                            else if (serializable instanceof Double value) cell.setCellValue(value);
                        });
                    });
                });
                try (FileOutputStream out = new FileOutputStream(fileName)) {
                    sheets.write(out);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        });

    }

    public static void load(String fileName) throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileName);
        final BXEXCELLexer bxexcelLexer = new BXEXCELLexer(charStream);
        final CommonTokenStream tokenStream = new CommonTokenStream(bxexcelLexer);
        final BXEXCELParser bxexcelParser = new BXEXCELParser(tokenStream);
        final var all = bxexcelParser.all();
        CelVisitor celVisitor = new CelVisitor();
        celVisitor.visitAll(all);
        inject(celVisitor.fileSheetXAValueMap);
    }

}
