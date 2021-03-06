package com.easy.mes.analysis.handler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @author zhaohan
 * @date 2021-10-2
 */

@Component
public class NettyClient {

    /**
     * 配置客户端NIO线程组
     */
    EventLoopGroup group = new NioEventLoopGroup();

    public void connect(int port, String host) throws Exception {

        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new FirstResponseHandler());
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();

            // 当客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            //netty断线重连
            connect(port,host);
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }
}

