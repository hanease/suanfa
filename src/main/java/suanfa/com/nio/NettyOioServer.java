package suanfa.com.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class NettyOioServer {

    public static void main(String[] args) throws Exception {
        server(9918);
    }
    //Listing 4.3 Blocking networking with Netty
    //1.创建一个 ServerBootstrap
    //
    //2.使用 OioEventLoopGroup 允许阻塞模式（OIO）
    //
    //3.指定 ChannelInitializer 将给每个接受的连接调用
    //
    //4.添加的 ChannelHandler 拦截事件，并允许他们作出反应
    //
    //5.写信息到客户端，并添加 ChannelFutureListener 当一旦消息写入就关闭连接
    //
    //6.绑定服务器来接受连接
    //
    //7.释放所有资源
    //
    //下面代码是使用 Netty NIO 实现。

    public static void server(int port) throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
        EventLoopGroup group = new OioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();        //1

            b.group(group)                                    //2
                    .channel(OioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {//3
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {            //4
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);//5
                                }
                            });
                        }
                    });
            ChannelFuture f = b.bind().sync();  //6
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();        //7
        }
    }

    //Listing 4.4 Asynchronous networking with Netty
    //1.创建一个 ServerBootstrap
    //
    //2.使用 NioEventLoopGroup 允许非阻塞模式
    //
    //3.指定 ChannelInitializer 将给每个接受的连接调用
    //
    //4.添加的 ChannelInboundHandlerAdapter() 接收事件并进行处理
    //
    //5.写信息到客户端，并添加 ChannelFutureListener 当一旦消息写入就关闭连接
    //
    //6.绑定服务器来接受连接
    //
    //7.释放所有资源
    public void server1(int port) throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();    //1
            b.group(new NioEventLoopGroup(), new NioEventLoopGroup())   //2
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {    //3
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {    //4
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(buf.duplicate())                //5
                                            .addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            ChannelFuture f = b.bind().sync();                    //6
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();                    //7
        }
    }
}
