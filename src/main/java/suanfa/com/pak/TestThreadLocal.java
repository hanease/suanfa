package suanfa.com.pak;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadLocal {

    //创建两个ThreadLocal对象
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal test = new TestThreadLocal();
        ExecutorService executors= Executors.newFixedThreadPool(2);
        executors.execute(new Runnable() {
            @Override
            public void run() {
                test.longLocal.set(Thread.currentThread().getId());
                test.stringLocal.set(Thread.currentThread().getName());
                System.out.println(test.longLocal.get());
                System.out.println(test.stringLocal.get());
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {
                test.longLocal.set(Thread.currentThread().getId());
                test.stringLocal.set(Thread.currentThread().getName());
                System.out.println(test.longLocal.get());
                System.out.println(test.stringLocal.get());
            }
        });
    }
}
