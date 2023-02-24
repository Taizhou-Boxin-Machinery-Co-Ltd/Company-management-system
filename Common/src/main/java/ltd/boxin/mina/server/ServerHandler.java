package ltd.boxin.mina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ServerHandler extends IoHandlerAdapter {
    private final Map<String, SocketAddress> hasLogin = new HashMap<>();
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
        System.out.println("welcome client: " + session.getRemoteAddress());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("client "+ session.getRemoteAddress() + " closed");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        System.out.println(session.getRemoteAddress().toString());
        if (String.valueOf(message.toString().charAt(0)).equals("/")) {
            System.out.println(message + " has command");
            String commandLines = message.toString().substring(1);
            String[] s = commandLines.split(" ");
            System.out.println(s[0]);
            if ("login".equals(s[0])) {
                if (!hasLogin.containsKey(s[1]) || hasLogin.get(s[1]) == null) {
                    hasLogin.put(s[1], session.getRemoteAddress());
                    session.write("user " + s[1] + " login!");
                } else {
                    session.write("user " + s[1] + " has login!");
                }
            }
        }
        System.out.println(message);
        session.write("echo " + message);
    }
}
