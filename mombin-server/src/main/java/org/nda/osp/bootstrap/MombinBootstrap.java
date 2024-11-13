package org.nda.osp.bootstrap;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
@CommandLine.Command
public class MombinBootstrap implements Runnable {

    private static final int DEFAULT_PORT = 9778;


    @CommandLine.Option(names = "--port")
    private Integer port;
    @CommandLine.Option(names = "--workers")
    private Integer workers;

    public static void start(String... args) {
        CommandLine.run(new MombinBootstrap(), args);
    }

    @Override
    public void run() {
        EventLoopGroup workerGroup;
        allocatePort();
        workerGroup = allocateWorkers();
        log.info("Server starts on {} port", port);
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {

                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    private void allocatePort() {
        if (port == null) {
            port = DEFAULT_PORT;
        }
    }

    private EventLoopGroup allocateWorkers() {
        return workers == null ? new NioEventLoopGroup() : new NioEventLoopGroup(workers);
    }
}
