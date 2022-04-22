package suanfa.com.nio;

import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args){

        FileWriter fw = null;
        try{
            //用FileWriter的另一种构造方法，传递一个true参数，代表不覆盖已有的文件。并在已有文件进行续写
            fw = new FileWriter("/Users/hanwenda/linuxPrj/fileTest/Demo.txt",true);
            //调用write方法，将字符串写入到流当中去，也就是缓冲区中
            fw.write("234334\r\n谢谢");

        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //创建一个文件读取流对象，和指定的名称的文件相关联
        //要保证该文件是已经存在的，如果不存在，会发生FileNotFoundException
        FileReader fr = null;
        try {
            fr = new FileReader("/Users/hanwenda/linuxPrj/fileTest/Demo.txt");

            //一次读取一个字符，而且会自动往下读
            /* int char1 = fr.read();
            System.out.println("char1="+(char)char1);//char1=a
            int char2 = fr.read();
            System.out.println("char2="+(char)char2);//char2=b
            int char3 = fr.read();
            System.out.println("char3="+(char)char3);//char3=c
            int char4 = fr.read();
            System.out.println("char4="+(char)char4);//char4=e
            int char5 = fr.read();
            System.out.println("char5="+(char)char5);
            int char6 = fr.read();
            System.out.println("char6="+(char)char6);
            int char7 = fr.read();
            System.out.println("char7="+char7);*/
            //如果达到流的末尾，则返回-1，-1为数据的分割符
            int ch = 0;
            while((ch=fr.read())!= -1){
                System.out.print((char)ch);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }


        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("d:\\1.jpg");//读取图像数据之类的原始字节流
            fos = new FileOutputStream("2.bmp");//用于写入诸如图像数据之类的原始字节流
            byte[] b = new byte[1024];
            int len = 0;
            while ((len=fis.read(b)) != -1){
                fos.write(b);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            throw new RuntimeException("复制图片失败！");
        }finally{
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
