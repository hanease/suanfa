package suanfa.com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class NioTest {
    public static void main(String[] args) throws IOException {

    }

    public void NioTest1() {
        try(
            FileInputStream fis = new FileInputStream("1.jpg");//放在项目根目录下
            FileOutputStream fos = new FileOutputStream("2.jpg");//最后要生成的文件名
            //1、通过文件流获取通道
            FileChannel inChannel =fis.getChannel();
            FileChannel outChannel =fos.getChannel();){

            //2、通过ByteBuffer.allocate分配指定大小的非直接缓冲区
            ByteBuffer buf =ByteBuffer.allocate(1024);

            //3、将in通道中的数据存入缓存
            while(inChannel.read(buf)!=-1){
                buf.flip();//把缓冲区切换成读模式
                //4、将缓冲区的数据写入out通道
                outChannel.write(buf);
                buf.clear();//清空緩存
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void NioTest2() {
        //1、通过FileChannel.open获取通道
        try(FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE)){
            //2、通过fileChannel的map方法获取直接缓冲区，即内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //3、直接对缓冲区进行操作，无需通过channel
            byte[] dst= new byte[inMappedBuf.limit()];// inChannel.size()和inMappedBuf.limit()一样的
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NioTest3() {
        //1、通过FileChannel.open获取通道
        try(FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE)){

            //inChannel.transferTo(0,inChannel.size(),outChannel);//transferTo底层和上面例子2差不多
            outChannel.transferFrom(inChannel,0,inChannel.size());//和transferTo一样，只是方向反一下而已
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NioTest4() throws IOException {
        //一、将通道中的数据分散读取到多个缓冲区中
        RandomAccessFile inRaf = new RandomAccessFile("1.txt", "rw");//1.txt为要读取的文件
        //1、通过RandomAccessFile获取通道
        FileChannel inChannel = inRaf.getChannel();

        //2、分配多个直接缓冲区,放到数组中
        ByteBuffer[] bufs = {ByteBuffer.allocate(102), ByteBuffer.allocate(1024)};

        //3、将通道中的数据分散读取到多个缓冲区中
        inChannel.read(bufs);

        //验证一下bufs的数据
        Arrays.stream(bufs).forEach(buf -> buf.flip());//先把每个缓冲区转换成读模式
        Arrays.stream(bufs).forEach(buf -> System.out.println(new String(buf.array()) + "\n----------------"));//可以看到，把1.txt的内容打印出来了

        //关闭流
        inRaf.close();
        inChannel.close();

        //二、将多个缓冲区的数据聚集到通道中
        RandomAccessFile outRaf = new RandomAccessFile("2.txt", "rw");//2.txt为要写入的文件,会自动创建
        //1、通过RandomAccessFile获取通道
        FileChannel outChannel = outRaf.getChannel();
        outChannel.write(bufs);

        //关闭流
        outRaf.close();
        outChannel.close();
    }

    public void client() throws IOException {

        //1、获取网络传输客户端通道，默认都是阻塞通讯
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2、分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //3、读取本地文件到缓冲区
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        while (inChannel.read(buf) != -1) {
            buf.flip();
            //4、将缓冲区的数据写入socketChannel
            socketChannel.write(buf);
            buf.clear();
        }
        //5、告诉服务端我已经发完了，如果不写这个，服务端就一直监听客户端数据,导致阻塞
        socketChannel.shutdownOutput();
        //6、接收反馈
        int len=0;
        while((len=socketChannel.read(buf))!=-1){
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }
        //5、关闭
        socketChannel.close();
        inChannel.close();
    }

    public void server() throws IOException {
        //1、获取网络传输服务端通道，并绑定本地连接的端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //2、获取客户端连接的通道（阻塞监听）
        SocketChannel clientSocketChannel = serverSocketChannel.accept();

        //3、获取写数据到本地的文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //4、分配制定大小的非直接缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //5、接收客户端的数据到缓冲区
        while(clientSocketChannel.read(buf)!=-1){
            buf.flip();
            //把缓冲区的数据保存到本地
            fileChannel.write(buf);
            buf.clear();
        }
        //6、反馈给客户端
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();
        clientSocketChannel.write(buf);

        //关闭
        serverSocketChannel.close();
        clientSocketChannel.close();
        fileChannel.close();
    }
}
