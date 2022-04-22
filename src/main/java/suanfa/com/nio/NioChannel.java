package suanfa.com.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioChannel {

    public static void main(String[] args) throws IOException {
        System.out.println("--------------------------");
        run4();
        System.out.println("--------------------------");
        run3();
        System.out.println("--------------------------");
        run2();
        System.out.println("--------------------------");


    }

    public static void run4() throws IOException{
        //1.分散读取
        RandomAccessFile raf1=new RandomAccessFile("/Users/hanwenda/linuxPrj/file1.txt", "rw");
        File tme = new File("/Users/hanwenda/linuxPrj/file1.txt");
        //获取通道
        FileChannel channel1 = raf1.getChannel();
        //分配两个指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //构建缓冲区数组
        ByteBuffer[] bufArr={buf1,buf2};
        //通道读取
        channel1.read(bufArr);
        //切换缓冲区为写模式
        for (ByteBuffer byteBuffer : bufArr) {
            byteBuffer.flip();
        }
        System.out.println(new String(bufArr[0].array(), 0, bufArr[0].limit()));
        System.out.println("--------------------------");
        System.out.println(new String(bufArr[1].array(), 0, bufArr[1].limit()));

        //2.聚集写入
        //聚集写入到2.txt中
        RandomAccessFile raf2=new RandomAccessFile("/Users/hanwenda/linuxPrj/file3.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        //将缓冲区数组写入通道中
        channel2.write(bufArr);
    }

    //3.通道之间的数据传输，直接缓冲区
    public static void run3() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("/Users/hanwenda/linuxPrj/file3.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/hanwenda/linuxPrj/file4.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
//      inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
    }

    public static void run2() throws IOException {
        long start=System.currentTimeMillis();
        //获取通道
        //读模式
        FileChannel inChannel = FileChannel.open(Paths.get("/Users/hanwenda/linuxPrj/file3.txt"), StandardOpenOption.READ);
        //读写模式
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/hanwenda/linuxPrj/file5.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //对缓冲区的数据进行读写操作
        byte[] by=new byte[inBuf.limit()];
        inBuf.get(by);
        outBuf.put(by);
        inChannel.close();
        outChannel.close();
        long end=System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));
    }

    public static void run() throws IOException{
        long start=System.currentTimeMillis();
        FileInputStream fis=null;
        FileOutputStream fos=null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis=new FileInputStream("/Users/hanwenda/linuxPrj/file3.txt");
            fos=new FileOutputStream("/Users/hanwenda/linuxPrj/file5.txt");
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //分配指定大小的缓冲区
            ByteBuffer bb = ByteBuffer.allocate(1024);
            //将通道中的数据存入缓冲区,这个时候的缓冲区是写模式
            while(inChannel.read(bb)!=-1){
                //将缓冲区切换为读模式
                bb.flip();
                outChannel.write(bb);
                bb.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fis.close();
            fos.close();
            inChannel.close();
            outChannel.close();
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start));
    }
}
