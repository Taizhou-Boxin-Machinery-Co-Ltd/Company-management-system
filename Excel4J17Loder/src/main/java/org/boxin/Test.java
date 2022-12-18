package org.boxin;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String name = "C:\\Users\\Administrator\\desktop\\1.xlsx";
        Load.main(name);
        Load.records.forEach(System.out::println);
//        Load.fileXssfListMap.forEach((s, stringXSSFSheetMap) -> {
//            stringXSSFSheetMap.forEach((s1, rows) -> {
//                System.out.println(s1);
//            });
//        });
    }
}
