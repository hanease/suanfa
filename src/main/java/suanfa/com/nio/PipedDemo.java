package suanfa.com.nio;

import java.io.*;

public class PipedDemo {

    public static void main(String[] args) throws IOException{

        //输出管道流连接输入管道流
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();
        try {
            out.connect(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//输出管道流连接输入管道流
        new Thread(new OutputThread(out)).start();
        new Thread(new InputThread(in)).start();

        //ByteArrayStreamDemo对象中方法。
        String str = "HELLO WORLD!";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());//将内容输入到内存中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//将内存中的数据输出
        int ch = 0;
        bis.skip(2);//跳过两个字节
        System.out.println(bis.available());//返回此输入流读取的（或跳过）剩余的字节数
        while((ch=bis.read())!=-1){
            bos.write(Character.toLowerCase(ch));//将大小字符转化成小写
        }
        System.out.println(bos.toString());

        //RandomAccessFile对象中方法。
        RandomAccessFile raf = new RandomAccessFile("/Users/hanwenda/linuxPrj/fileTest/ranacc.txt", "rw");

        //通过seek设置指针的位置。
        raf.seek(1*8);//随机的读取。只要指定指针的位置即可。

        byte[] buf = new byte[4];
        raf.read(buf);

        String name = new String(buf);//

        int age = raf.readInt();//从当前指针开始读4个字节

        System.out.println("name="+name);
        System.out.println("age="+age);

        System.out.println("pos:"+raf.getFilePointer());//获取指针的位置

        raf.close();
    }


}
