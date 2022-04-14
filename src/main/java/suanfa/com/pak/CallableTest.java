package suanfa.com.pak;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }

    private static void doTaskWithResultInWorker() {
        //看出 Callable 最大区别就是返回范型 V 结果
        Callable<Integer> callable = new Callable<Integer>() {

            //这里需要重写call方法，而不是run方法
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i=0; i<=100; i++) {
                    result += i;
                }
                return result;
            }
        };
        //Callable需要把对象放入FutureTask对象中，在把FutureTask对象放入Thread中，就可以启动一个线程
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Result: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        } }
}
