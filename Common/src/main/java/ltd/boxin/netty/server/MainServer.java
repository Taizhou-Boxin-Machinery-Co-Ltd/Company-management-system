package ltd.boxin.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainServer {
    private final int port;
    //维持在线的客户端
    private final Map<String, Boolean> clientMap = new HashMap<>();

    //添加客户端
    public synchronized void setClient(String name) {
        this.clientMap.put(name, true);
    }
    //断线溢出
    public synchronized void removeClient(String name) {
        this.clientMap.remove(name);
    }
    // 判断是否有客户端在连接
    public synchronized boolean getClientMapSize() {
        return this.clientMap.size() > 0;
    }

    private final Map<String, Channel> channelMap = new HashMap<>();

    public synchronized void setChannel(String name, Channel channel) {
        this.channelMap.put(name, channel);
    }

    public synchronized Map<String, Channel> getChannelMap() {
        return this.channelMap;
    }

    public boolean writeMsg(String msg) {
        boolean errorFlag = false;
        var channelMap = getChannelMap();
        if (channelMap.size() == 0) {
            return true;
        }
        var keySet = channelMap.keySet();
        for (var key: keySet) {
            try {
                var channel = channelMap.get(key);
                if (!channel.isActive()) {
                    errorFlag = true;
                    continue;
                }
                channel.writeAndFlush(msg + System.getProperty("line.separator"));
            } catch (Exception e) {
                errorFlag = true;
            }
        }
        return errorFlag;
    }

    public void bind() {
        System.out.println("service start successful");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //特殊分隔符
                        pipeline.addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE,
                                Unpooled.copiedBuffer(System.getProperty("line.separator").getBytes())));
                        pipeline.addLast("decoder", new StringDecoder());
                        pipeline.addLast("encoder", new StringEncoder());
                        pipeline.addLast(new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
                        pipeline.addLast("handler", new MainServerHandler(MainServer.this));
                    }
                });
        try {
            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public MainServer(int port) {
        this.port = port;
    }

}
