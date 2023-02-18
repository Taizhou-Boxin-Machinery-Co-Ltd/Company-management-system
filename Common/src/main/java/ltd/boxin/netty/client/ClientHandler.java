package ltd.boxin.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<String> {
    public ChannelHandlerContext channelHandlerContext;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        channelHandlerContext = ctx;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
    }
}
