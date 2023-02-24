package ltd.boxin.config;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.util.Objects;

/**
 * @author baka4n
 * 配置文件为空时候默认从资源列表抽出
 */
public class ConfigCopyAndCreate {
    public static final Gson gson = new Gson();
    public static int port = 25598;
    public static String host = "127.0.0.1";

    public static void copy() throws IOException {
        File file = new File(System.getProperty("user.dir"), ".server/config.json");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = ConfigCopyAndCreate.class.getResourceAsStream("/config.json");
            out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buf)) > 0) {
                out.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
            out.close();
        }

    }

    public static void init() {
        try {
            copy();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        var linkedTreeMap = gson.fromJson(new InputStreamReader(Objects.requireNonNull(ConfigCopyAndCreate.class.getResourceAsStream("/config.json"))), LinkedTreeMap.class);
        if (linkedTreeMap.get("port") instanceof Double d) {
            port = (int) d.doubleValue();
        }
    }
}
