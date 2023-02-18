package ltd.boxin.api;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.ArrayList;
import java.util.List;

public class NettyServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        String s = buf.toString(CharsetUtil.UTF_8);
        if (s.contains("你好,服务端!")) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("你好,客户端!", CharsetUtil.UTF_8));
        }
        System.out.println("客户端发送: " + s);
        System.out.println("客户端地址为:" + ctx.channel().remoteAddress());
    }


    /**
     * 处理异常,一般是关闭通道
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
