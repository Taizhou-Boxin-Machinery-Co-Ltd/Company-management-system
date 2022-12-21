package org.boxin.utils.algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author baka4n
 * @since 通过configs生成自定义加密算法
 */
public class Configs {
    public static final File file = new File(System.getProperty("user.dir"), "configs");
    public static final File file1 = new File(file, "locker.rules");
    public static void createOrLoad() {

        if (!file.exists()) file.mkdirs();

        if (!file1.exists()) {
            try(BufferedWriter br = new BufferedWriter(new FileWriter(file1))) {
                br.write("<< 199999;");
                br.newLine();
                br.write("+ 1923222;");
                br.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
