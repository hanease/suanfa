package suanfa.com.nio;

import java.io.File;

public class FileDeepList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dir = new File("/Users/hanwenda/linuxPrj/fileTest"+File.separator+"demodir");
        showDirDeep(dir,0);
    }
    /**
     * 深度遍历目录下面的内容，递归，包含子目录的内容
     * @param dir
     */
    public static void showDir(File dir){
        File[] files = dir.listFiles();
        for(int i=0;i<files.length;i++){
            if(dir.exists()){
                if(files[i].isDirectory()){//如果是文件夹，继续列出指定子文件夹的内容
                    showDir(files[i]);//使用递归
                }else{
                    System.out.println(files[i].getName());//是文件
                }
            }
        }
    }
    /**
     * 深度遍历目录下面的内容，递归，包含子目录的内容,并且使得遍历的目录有层次，加个层次计数器，第几层就加几
     * @param dir 目录或者文件
     * @param level 深度遍历层次计数器
     */
    public static void showDirDeep(File dir,int level){
        if(!dir.exists()){
            System.out.println("遍历的目录为空！");
        }
        System.out.println(getSpace(level)+dir.getName());
        level++;
        File[] files = dir.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isDirectory()){//如果是文件夹，继续列出指定子文件夹的内容
                showDirDeep(files[i],level);//使用递归
            }else{
                System.out.println(getSpace(level)+files[i].getName());//是文件
            }
        }
    }
    /**
     * 格式化层次
     * @param level
     * @return
     */
    private static String getSpace(int level) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<level;i++){//几层就拼几个字符
            sb = sb.append("|--");
        }
        return sb.toString();
    }
}
