package suanfa.com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioNotBlock {

    public static void main(String[] args) throws IOException {

    }

    public void client() throws IOException {

        //1、获取网络传输客户端通道、并切换为非阻塞模式
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        socketChannel.configureBlocking(false);

        //2、分配指定大小的缓冲区，并写入数据
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put("客服端的数据".getBytes());

        //4、将缓冲区的数据写入socketChannel
        buf.flip();
        socketChannel.write(buf);

        //5、关闭
        socketChannel.close();
    }

    public void server() throws IOException {
        //1、获取网络传输服务端通道，并设置为非阻塞模式，并绑定本地连接的端口,
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //2、获取选择器,并把服务端通道绑定到选择器
        Selector selector= Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//指定服务端监听接收事件（此时还没有客服连接进来，所以是未就绪）

        //3、selector.select()已经就绪的channel，
        while(selector.select()>0){
            System.out.println("有就绪好的channel了，我进来了");
            //4、获取当前选择器中所有已经注册的“选择键”，也就是已经就绪的监听事件，步骤2已经注册了serverSocketChannel
            Iterator<SelectionKey> skIterator = selector.selectedKeys().iterator();

            while (skIterator.hasNext()){
                //5、获取准备就绪的事件
                SelectionKey sk = skIterator.next();

                //6、判断具体是什么事件准备就绪
                if(sk.isAcceptable()){
                    //7、如果是接收就绪，获取客户端连接，并切换为非阻塞模式
                    SocketChannel clientSocketChannel = serverSocketChannel.accept();
                    clientSocketChannel.configureBlocking(false);

                    //8、将该通道注册到选择器上
                    clientSocketChannel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //9、获取当前选择器上“读就绪”状态的通道
                    SocketChannel clientSocketChannel = (SocketChannel) sk.channel();
                    //10、读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len=0;
                    while((len=clientSocketChannel.read(buf))!=-1){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                    //关闭
                    clientSocketChannel.close();
                }
                //注意，要删除此次的选择键,不然步骤4又循环到这个选择键
                selector.selectedKeys().remove(sk);
            }
        }
    }
}
