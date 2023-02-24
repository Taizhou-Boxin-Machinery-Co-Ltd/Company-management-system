package ltd.boxin;

import ltd.boxin.config.ConfigCopyAndCreate;
import ltd.boxin.mina.server.Server;
import ltd.boxin.netty.server.MainServer;

public class Main {
//    public static MainServer server = null;
    public static Server server;
    public static void main(String[] args) {
        ConfigCopyAndCreate.init();
        server = new Server(ConfigCopyAndCreate.port);
        server.main();
//        server = new MainServer(ConfigCopyAndCreate.port);
//        new Thread(() -> server.bind()).start();
    }
}