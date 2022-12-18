package org.boxin;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String name = "E:\\Users\\Administrator\\桌面\\元素属性表.xlsx";
        Load.main(name);
        Load.fileXssfListMap.forEach((s, stringXSSFSheetMap) -> {
            stringXSSFSheetMap.forEach((s1, rows) -> {
                System.out.println(s1);
            });
        });
    }
}
