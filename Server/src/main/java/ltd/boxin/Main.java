package ltd.boxin;

import ltd.boxin.config.ConfigCopyAndCreate;
import ltd.boxin.netty.server.MainServer;

public class Main {
    public static MainServer server = null;
    public static void main(String[] args) {
        ConfigCopyAndCreate.init();
        server = new MainServer(ConfigCopyAndCreate.port);
        new Thread(() -> server.bind()).start();
    }
}