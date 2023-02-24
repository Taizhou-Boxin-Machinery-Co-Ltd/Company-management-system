package ltd.boxin.mina.client;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

public class Client {
    private String host;
    private int port;
    private ConnectFuture cf;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void main() {
        NioSocketConnector connector = new NioSocketConnector();
        DefaultIoFilterChainBuilder chain = connector.getFilterChain();
        chain.addLast("objectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        connector.setHandler(new ClientHandler());
        connector.setConnectTimeoutMillis(10000);
        cf = connector.connect(new InetSocketAddress(host, port));
        cf.awaitUninterruptibly();
    }
    public void sendMessage(String message) {
        cf.getSession().write(message);
    }
}
