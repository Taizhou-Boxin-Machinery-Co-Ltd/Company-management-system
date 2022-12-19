package org.boxin;

import org.antlr.v4.runtime.*;
import org.apache.poi.xssf.usermodel.*;
import org.boxin.g4.*;

import java.io.*;
import java.util.*;

/**
 * @author baka4n
 * @since 用于快速导入excel
 */
public class Inject {
    public static final List<String> fileNameList = new ArrayList<>();//生成的文件保存数据
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
                    fileNameList.add(fileName);
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

    public static void save() {
        StringBuilder a = new StringBuilder();
        final File file = new File(System.getProperty("user.dir"));
        final File path = new File(file, "configs.cfg");
        if (!file.exists()) file.mkdirs();
        if (!path.exists()) try {
            file.createNewFile();
        } catch (IOException e) {}
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\configs.cfg"))) {
            String line;
            while ((line = br.readLine()) != null) a.append(line).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\configs.cfg"))) {
            bw.write(a.toString());
            bw.newLine();
            fileNameList.forEach(fileName -> {
                try {
                    bw.write(fileName);
                    bw.newLine();
                } catch (IOException e) {}
            });
        } catch (IOException e) {}
    }
    public static void load() {
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\configs.cfg"))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileNameList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
