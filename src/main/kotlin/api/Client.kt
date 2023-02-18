package api

import io.netty.bootstrap.Bootstrap
import io.netty.channel.*
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import ltd.boxin.api.NettyClientHandler


class Client: Runnable {

    val bootstrap = getBootStrap()
    val channel = getChannel("127.0.0.1", 25599)

    fun getBootStrap() : Bootstrap {
        val clientLoopGroup = NioEventLoopGroup()
        val bootstrap = Bootstrap()
        bootstrap.group(clientLoopGroup) //设置线程组
            .channel(NioSocketChannel::class.java) //设置客户端通道实现类
            .handler(object : ChannelInitializer<SocketChannel>() {
                @Throws(Exception::class)
                override fun initChannel(socketChannel: SocketChannel) {
//                    val nettyClientHandler = NettyClientHandler()
                    socketChannel.pipeline().addLast(LineBasedFrameDecoder(1024))
                    socketChannel.pipeline().addLast(StringDecoder())
                    socketChannel.pipeline().addLast(StringEncoder())
//                    socketChannel.pipeline().addLast(nettyClientHandler) //加入自定义处理器
                }
            })
        println("客户端已准备就绪")
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
        return bootstrap
    }

    fun getChannel(host: String, port: Int): Channel {
        return bootstrap.connect(host, port).sync().channel()
    }

    override fun run() {
    }

    fun sendMsg(msg: String) {

        channel.writeAndFlush(msg)
    }
}