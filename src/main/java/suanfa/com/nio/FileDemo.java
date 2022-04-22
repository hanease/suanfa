package suanfa.com.nio;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        //listRoots();
        //createFileMethod();
        //createTempFileMethod();
        //createDirMethod();
        listFileterDemo();
        listFileDemo();
    }
    //创建文件
    public static void createFileMethod(){
        File file = new File("/Users/hanwenda/linuxPrj/fileTest/demodir/file13.txt");
        try {
            boolean b = file.createNewFile();
            System.out.print(b);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //创建临时文件
    public static void createTempFileMethod(){
        File dir = new File("/Users/hanwenda/linuxPrj/fileTest/");
        try {
            File b = File.createTempFile("test", ".tmp",dir);//使用指定目录的方法
            System.out.print(b.getAbsolutePath());
            File b1 = File.createTempFile("tmp2", null);//使用不指定目录的构造方法
            System.out.print(b1.getAbsolutePath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //创建目录
    public static void createDirMethod(){
        File dir = new File("/Users/hanwenda/linuxPrj/fileTest"+File.separator+"dfr"+File.separator+"ddd");
        File dir1 = new File("/Users/hanwenda/linuxPrj/fileTest"+File.separator+"dff"+File.separator+"ddd");
        boolean b = dir.mkdirs();//可以递归的创建不存在的目录
        boolean b1 = dir1.mkdir();//创建目录，不能递归，只能创建一级目录
        System.out.println(b);
        System.out.println(b1);
    }

    //删除文件
    public static void deleteFileMethod(){
        File file = new File("/Users/hanwenda/linuxPrj/fileTest/file.txt");
        try {
            boolean b = file.createNewFile();
            System.out.print(b);
            file.deleteOnExit();
            file.delete();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //判断文件对象或者目录是否是文件或者目录时候，必须判断该文件是否存在
    public static void IsDirOrFileMethod() throws IOException{
        File file  = new File("/Users/hanwenda/linuxPrj/fileTest/a.txt");
        File file1  = new File("/Users/hanwenda/linuxPrj/fileTest"+File.separator+"hhh");
        file.createNewFile();
        file1.mkdir();
        System.out.println("是否存在"+file.exists());
        System.out.println("是否是文件"+file.isFile());
        System.out.println("是否是目录"+file.isDirectory());
        System.out.println("是否是隐藏"+file.isHidden());
        System.out.println("目录是否为绝对目录名"+file1.isAbsolute());
        System.out.println("file对象对应的文件目录是否可write: "+file1.canWrite());
        System.out.println("file对象对应的文件目录是否可read: "+file1.canRead());
        System.out.println("file对象对应的文件目录是否可Execute: "+file1.canExecute());
    }
    //获取的方法
    public static void getMehtod(){
        File file = new File("/Users/hanwenda/linuxPrj/fileTest/file2.txt");
        File dir = new File("/Users/hanwenda/linuxPrj/fileTest/abc");
        System.out.println("获取抽象路径名转化为路径名字字符串："+file.getPath());//E:\file2.txt
        System.out.println("获取此File对象对应的绝对路径名："+file.getAbsolutePath());//E:\file2.txt
        System.out.println("获取此File对象的所对应目录（最后一级子目录（绝对路径））的父目录名："+file.getParent());//E:\
        System.out.println("获取此File对象最后修改时间："+file.lastModified());//1405853667765,修改日期的毫秒数
    }
    //相当于重命名剪切
    public static void renameFile() throws IOException{
        File f1 = new File("/Users/hanwenda/linuxPrj/fileTest/file.txt");
        File f2 = new File("/Users/hanwenda/linuxPrj/fileTest/file2.txt");
        System.out.println("f1重命名为f2的名字"+f1.renameTo(f2));
        //System.out.println("f2重命名为f1的名字"+f2.renameTo(f1));
    }

    //列出根目录的全部内容
    public static void listRoots(){
        File[] files = File.listRoots();
        for(File file:files){
            System.out.println("列出根目录："+file);
        }
    }
    //列出指定的目录的全部内容,包括隐藏文件，文件夹的名字和文件的名字
    public static void listDemo(){
        File f = new File("/Users/hanwenda/linuxPrj/fileTest/");
        System.out.println("获取D盘的可用空间"+f.getFreeSpace());
        System.out.println("获取D盘的可用于虚拟机的空间"+f.getUsableSpace());
        System.out.println("获取D盘的总容量"+f.getTotalSpace());
        String[] files = f.list();
        for(String file:files){
            System.out.println("列出根目录："+file);
        }
    }
    //列出指定的目录的全部内容,包括隐藏文件，文件夹的名字和文件的名字
    public static void listFileterDemo(){
        File f = new File("/Users/hanwenda/linuxPrj/fileTest/");
        String[] files = f.list();
        for(String file:files){
            System.out.println("列出根目录："+file);
        }
    }
    //列出指定的目录的全部内容,包括隐藏文件，文件夹的名字和文件的名字,使用 File[] listFiles()
    //返回值为一个File对象
    public static void listFileDemo(){
        File f = new File("/Users/hanwenda/linuxPrj/fileTest/");
        File[] files = f.listFiles();
        for(File file:files){
            System.out.println("列出根目录："+file.getName());
        }
    }
    /**
     * 列出指定目录下，后缀为.java的文件，使用方法String[] list(FilenameFilter filter)
     */
    public static void ListFileFileter(){
        File f = new File("/Users/hanwenda/linuxPrj/fileTest"+File.separator+"workspace"+File.separator+"IOTest");
        String[] files = f.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                //System.out.println("dir:"+dir+"name....."+name);//说明dir表示指定目录,name表示指定目录的名称
                return name.endsWith(".java");//通过匿名内部类的返回值来控制指定目录下面的文件和文件夹的显示
            }
        });
        System.out.println(files.length);
        //遍历指定目录下面的文件和目录
        for(String file:files){
            System.out.println(file);
        }
    }
}
