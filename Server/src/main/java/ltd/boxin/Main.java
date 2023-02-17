package ltd.boxin;

import com.google.gson.Gson;
import ltd.boxin.api.ServerThread;
import ltd.boxin.config.ConfigCopyAndCreate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {
    public static ServerSocket server = null;
    public static Socket request = null;
    public static Thread receiveThread = null;
    public static void main(String[] args) {
        ConfigCopyAndCreate.init();
        try {
            server = new ServerSocket(ConfigCopyAndCreate.port);
            System.out.println("Welcome to the server!");
            System.out.println(new Date());
            System.out.println("The server is ready!");
            System.out.println("Port: " + ConfigCopyAndCreate.port);
            while (true) { //等待用户请求
                request = server.accept();//接收客户机连接请求
                receiveThread = new ServerThread(request);//生成serverThread的实例
                receiveThread.start();//启动serverThread线程
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}