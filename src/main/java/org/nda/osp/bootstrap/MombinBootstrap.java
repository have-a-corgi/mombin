package org.nda.osp.bootstrap;

import org.slf4j.Logger;
import picocli.CommandLine;

@CommandLine.Command
public class MombinBootstrap implements Runnable {

    @CommandLine.Option(names = "--port")
    private Integer port;

    public static void start(String... args) {
        CommandLine.run(new MombinBootstrap(), args);
    }

    @Override
    public void run() {
        if (port == null) {
            port = 1024;
        }
        System.out.println("POrt is "+port);
        /*EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(9676).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }*/
    }
}
