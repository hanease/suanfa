package suanfa.com.nio;

import java.io.*;

public class BufferReaderDemo {

    private FileReader r;
    public BufferReaderDemo(FileReader r){
        this.r = r;
    }

    public static void main(String[] args) throws IOException {
        //创建一个读取流对象和文件相关联
        FileReader fr = new FileReader("/Users/hanwenda/linuxPrj/fileTest/FileDemo.java");
        //为了提高字符读取的效率，加入缓冲技术
        //将需要被提高效率的流对象作为参数传入缓冲区的构造方法即可
        BufferedReader bw = new BufferedReader(fr);
        String line = null;
        /*line = bw.readLine();
        System.out.println("******"+line);//一次性读取一行
        String line1 = bw.readLine();
        System.out.println("******"+line1);
        String line2 = bw.readLine();
        System.out.println("******"+line2);*/
        while((line=bw.readLine()) != null){
            System.out.println(line);
        }
        bw.close();

        //创建一个字符写入流对象
        FileWriter fw = new FileWriter("/Users/hanwenda/linuxPrj/fileTest/buf.txt");
        //为了提高字符写入的效率，加入缓冲技术
        //将需要被提高效率的流对象作为参数传入缓冲区的构造方法即可
        BufferedWriter bw1 = new BufferedWriter(fw);
        for(int i=0;i<5;i++){
            bw1.write("abcd"+i);
            bw1.newLine();
            bw1.flush();
        }

        FileReader fr1 = new FileReader("buf.txt");
        BufferReaderDemo mybuffer =  new BufferReaderDemo(fr);
        String line1 = null;
        while((line1 =mybuffer.myreadLine())!= null){
            System.out.println(line1);
        }
        mybuffer.myClose();

    }

    //可以一次性读一行数据的方法
    public String myreadLine() throws IOException{

        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while((ch = r.read()) != -1){
            if(ch == '\r'){
                continue;
            }
            if(ch == '\n'){
                return sb.toString();
            }else{
                sb.append((char)ch);
            }
        }
        if(sb.length() != 0){
            return sb.toString();
        }
        return null;
    }

    public void myClose() throws IOException{
        r.close();
    }
}
