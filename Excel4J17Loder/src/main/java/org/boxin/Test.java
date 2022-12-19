package org.boxin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
//        String name = "C:\\Users\\Administrator\\desktop\\1.xlsx";
//        Load.main(name);
//        Load.records.forEach(System.out::println);
//        Load.fileXssfListMap.forEach((s, stringXSSFSheetMap) -> {
//            stringXSSFSheetMap.forEach((s1, rows) -> {
//                System.out.println(s1);
//            });
//        });
        File file = new File("E:\\test.bx");
        if (!file.exists()) {
            Inject.load("E:\\test.bx");
        } else {
            Load.main(Inject.fileNameList.toArray(new String[0]));
        }
        Inject.save();

    }
}
