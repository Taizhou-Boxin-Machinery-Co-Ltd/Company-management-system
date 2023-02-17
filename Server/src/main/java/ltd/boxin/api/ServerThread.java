package ltd.boxin.api;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread {
    Socket clientRequest;
    BufferedReader input;
    PrintWriter output;
    public ServerThread(Socket s) {
        clientRequest = s;
        InputStreamReader reader;
        OutputStreamWriter writer;
        try {
            reader = new InputStreamReader(clientRequest.getInputStream());
            writer = new OutputStreamWriter(clientRequest.getOutputStream());
            input = new BufferedReader(reader);
            output = new PrintWriter(writer, true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("%s:%s\n", s.getInetAddress(), s.getPort());
        output.println("welcom to boxin server");
        output.println("Now is:" + new Date() + " " + "Port:" + clientRequest.getLocalPort());
        output.println("What can I do for you?");
    }

    public void run() {
        String command = null;
        String string = null;
        boolean done = false;
        while (!done) {
            try {
                string = input.readLine(); //接收客户机指令
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            command = string.trim().toUpperCase();
        }//end of while
        try {
            clientRequest.close(); //关闭套接字
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        command = null;
    }
}
