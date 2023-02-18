package ltd.boxin.api

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerAdapter
import io.netty.channel.ChannelHandlerContext
import io.netty.util.CharsetUtil

class NettyClientHandler : ChannelHandlerAdapter() {
    var ctx: ChannelHandlerContext? = null



    /**
     * 通道准备就绪时调用
     *
     * @param ctx
     * @throws Exception
     */
    override fun channelActive(ctx: ChannelHandlerContext) {
        this.ctx = ctx
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好,服务端!", CharsetUtil.UTF_8))
    }

    /**
     * 获取客户端回复
     * @param ctx
     * @param msg
     * @throws Exception
     */
    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        val buf = msg as ByteBuf
        val toString = buf.toString(CharsetUtil.UTF_8)
        println("服务端回复: " + toString)
    }

    /**
     * 处理异常,一般是关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        cause.printStackTrace()
        ctx.close()
    }
}