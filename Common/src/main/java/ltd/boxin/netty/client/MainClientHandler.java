package ltd.boxin.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.concurrent.TimeUnit;

public class MainClientHandler extends SimpleChannelInboundHandler {
    private MainClient client;
    private String tenantId;
    private int attempts = 0;
    public MainClientHandler(MainClient client) {
        this.client = client;
    }
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("service send message" + msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("output connected!");
        attempts = 0;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("offline");
        //断线重连机制
        final EventLoop eventLoop = ctx.channel().eventLoop();
        if (attempts < 12) {
            attempts++;
        }
        int timeout = 2<<attempts;
        eventLoop.schedule(() -> {
            client.start();
        }, timeout, TimeUnit.SECONDS);
        ctx.fireChannelInactive();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent event) {
            if (event.state().equals(IdleState.READER_IDLE)) {
                System.out.println("Reader_idle");
            } else if (event.state().equals(IdleState.WRITER_IDLE)) {
                //发送心跳，保持长连接
                String s = "NettyClient"+System.getProperty("line.separator");
                ctx.channel().writeAndFlush(s);  //发送心跳成功
            } else if (event.state().equals(IdleState.ALL_IDLE)) {
                System.out.println("All_idel");
            }
            super.userEventTriggered(ctx, evt);
        }
    }
}
