package suanfa.com.test;

public class JVMTest {

    public static void main(String[] args) {
        //这个程序连续创建了100个1M的数组对象，使用-XX:+PrintGC或-verbose:gc参数执行该程序，即可查看到GC情况：
        byte[] bytes = null;
        /*for (int i = 0; i < 100; i++) {
            bytes = new byte[1 * 1024 * 1024];
        }*/
        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");          //系统的最大空间
        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");    //系统的空闲空间
        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间

    }
}
