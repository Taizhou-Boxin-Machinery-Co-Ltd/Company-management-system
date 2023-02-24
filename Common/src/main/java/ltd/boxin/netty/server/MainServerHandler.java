package ltd.boxin.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class MainServerHandler extends SimpleChannelInboundHandler {
    private int counter = 0;
    private MainServer server;

    public MainServerHandler(MainServer server) {
        this.server = server;
    }
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg.toString());
        //重置心跳
        counter = 0;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        var clientName = ctx.channel().remoteAddress().toString();
        System.out.println("RemoteAddress:" + clientName + "active!");
        server.setClient(clientName);
        server.setChannel(clientName, ctx.channel());
        super.channelActive(ctx);
        counter = 0;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent event) {
            if (event.state().equals(IdleState.READER_IDLE)) {
                if (counter >= 10) {
                    ctx.channel().close().sync();
                    String clientName = ctx.channel().remoteAddress().toString();
                    System.out.println(clientName + "offline");
                    server.removeClient(clientName);
                    if (server.getClientMapSize()) {
                        return;
                    }
                } else {
                    counter ++;
                    System.out.println("loss" + counter + "count HB");
                }
            }
        }
    }
}
