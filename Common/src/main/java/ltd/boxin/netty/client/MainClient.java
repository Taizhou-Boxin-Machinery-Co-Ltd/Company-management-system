package ltd.boxin.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MainClient {
    private final String host;
    private final int port;
    private Channel channel;
    private Bootstrap b = null;
    public MainClientHandler handler = null;
    public MainClient(String host, int port) {
        this.host = host;
        this.port = port;
        init();
    }

    private void init() {
        b = new Bootstrap();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        b.group(workerGroup).option(ChannelOption.SO_KEEPALIVE, true)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE,
                                Unpooled.copiedBuffer(System.getProperty("line.separator").getBytes())));
                        //字符串编码解码
                        pipeline.addLast("decoder", new StringDecoder());
                        pipeline.addLast("encoder", new StringEncoder());
                        //心跳检测
                        pipeline.addLast(new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS));
                        //客户端的逻辑
                        handler = new MainClientHandler(MainClient.this);
                        pipeline.addLast("handler", handler);

                    }
                });
    }

    public void start() {
        ChannelFuture f = b.connect(host, port);
        //断线重连
        f.addListener((ChannelFutureListener) channelFuture -> {
            if (!channelFuture.isSuccess()) {
                final EventLoop loop = channelFuture.channel().eventLoop();
                loop.schedule(() -> {
                    System.out.println("not connect service");
                    start();
                }, 1L, TimeUnit.SECONDS);
            } else {
                channel = channelFuture.channel();
                System.out.println("connected");
            }
        });
    }

    public Channel getChannel() {
        return channel;
    }

    public void sendMessage(String msg) {
        channel.writeAndFlush(msg);
    }
}
