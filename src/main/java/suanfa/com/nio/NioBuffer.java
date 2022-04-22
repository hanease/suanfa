package suanfa.com.nio;

import java.nio.ByteBuffer;

public class NioBuffer {

    public static void main(String[] args) throws InterruptedException {
        String str="helloworld";
        //1.分配一个指定大小的缓冲区
        ByteBuffer bb=ByteBuffer.allocate(1024);
        System.out.println(bb.capacity());
        System.out.println(bb.limit());
        System.out.println(bb.position());

        //2.存入数据
        bb.put(str.getBytes());
        System.out.println(bb.capacity());
        System.out.println(bb.limit());
        System.out.println(bb.position());//位置变为10

        //3.切换读取数据模式
        bb.flip();
        System.out.println(bb.capacity());//缓冲区大小仍然为1024
        System.out.println(bb.limit());//可读取数量为10个的字节
        System.out.println(bb.position());//位置切换到0了，可以从0开始读取

        //4.读取数据
        byte[] by=new byte[bb.limit()];
        bb.get(by);//获取到缓冲区可读取的所有数据（也就是10）,存放在by数组中
        //System.out.println(by);
        System.out.println(new String(by,0,by.length));
        System.out.println(bb.capacity());
        System.out.println(bb.limit());
        System.out.println(bb.position());
        try {
            bb.get();//再读的话就越界了
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.rewind() ：可重复读数据
        bb.rewind();
        System.out.println(bb.capacity());
        System.out.println(bb.limit());
        System.out.println(bb.position());//位置变为0了，说明又可以读了

        //6.clear()：清空缓冲区，但是缓冲区的数据依然存在，但是处于“被遗忘状态”
        bb.clear();
        System.out.println(bb.capacity());
        System.out.println(bb.limit());//指针全部回到最原始状态，不知道有多少数据
        System.out.println(bb.position());
        System.out.println((char)bb.get());

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("--------------初始创建缓冲区allocate()----------------");
        System.out.println(byteBuffer.position());//输出0
        System.out.println(byteBuffer.limit());//输出1024
        System.out.println(byteBuffer.capacity());//输出1024

        System.out.println("--------------写模式put（）----------------");
        byteBuffer.put("abcde".getBytes());
        System.out.println(byteBuffer.position());//输出5
        System.out.println(byteBuffer.limit());//输出1024
        System.out.println(byteBuffer.capacity());//输出1024

        System.out.println("--------------切换到读模式flip（）----------------");
        byteBuffer.flip();//将缓冲区的.limit设置为position，并将positions设为 0
        System.out.println(byteBuffer.position());//输出0
        System.out.println(byteBuffer.limit());//输出5
        System.out.println(byteBuffer.capacity());//输出1024

        System.out.println("--------------开始读数据get（）----------------");
        byte[] dst = new byte[5];
        byteBuffer.get(dst);
        System.out.println(new String(dst,0,5));
        System.out.println(byteBuffer.position());//输出5
        System.out.println(byteBuffer.limit());//输出5
        System.out.println(byteBuffer.capacity());//输出1024

        System.out.println("--------------重新读数据rewind（）----------------");
        byteBuffer.rewind();//将position设为 0
        System.out.println(byteBuffer.position());//输出0
        System.out.println(byteBuffer.limit());//输出5
        System.out.println(byteBuffer.capacity());//输出1024

        System.out.println("-------------清空缓冲区数据clear（）----------------");
        byteBuffer.clear();//清空缓冲区，但是缓冲区的数据依然存在，只是位置、界限变成最初状态，这个方法主要用来重新写数据到缓存
        System.out.println(byteBuffer.position());//输出0
        System.out.println(byteBuffer.limit());//输出1024
        System.out.println(byteBuffer.capacity());//输出1024
        byte[] dst1 = new byte[2];
        byteBuffer.get(dst1);
        System.out.println(new String(dst1));//输出ab

        System.out.println("--------------标记位置mark（），恢复到标记的位置reset（）----------------");
        byteBuffer.mark(); //对缓冲区设置标记
        byteBuffer.get(dst1);
        System.out.println(new String(dst1));//输出cd
        byteBuffer.reset();//将 position 回复到以前设置的 mark 所在的位置
        byteBuffer.get(dst1);
        System.out.println(new String(dst1));//又输出cd


    }

}
