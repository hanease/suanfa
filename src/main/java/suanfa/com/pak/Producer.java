package suanfa.com.pak;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private volatile boolean  isRunning = true;//是否在运行标志
    private BlockingQueue<String> queue;//阻塞队列
    private static AtomicInteger count = new AtomicInteger();//自动更新的值

    //构造函数
    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        String data = null;
        System.out.println(Thread.currentThread().getName()+" 启动生产者线程！");
        try {
            while (isRunning) {
                Thread.sleep(1000);

                //以原子方式将count当前值加1
                data = "" + count.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+" 将生产数据：" + data + "放入队列中");

                //设定的等待时间为2s，如果超过2s还没加进去返回false
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName()+" 放入数据失败：" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName()+" 退出生产者线程！");
        }
    }

    public void stop() {
        isRunning = false;
    }
}
