package suanfa.com.pak;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{

    private BlockingQueue<String> queue;

    //构造函数
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" 启动消费者线程！");

        boolean isRunning = true;
        try {
            while (isRunning) {
                //有数据时直接从队列的队首取走，无数据时阻塞，在2s内有数据，取走，超过2s还没数据，返回失败
                String data = queue.poll(2, TimeUnit.SECONDS);

                if (null != data) {
                    System.out.println(Thread.currentThread().getName()+" 正在消费数据：" + data);
                    Thread.sleep(1000);
                } else {
                    // 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName()+" 退出消费者线程！");
        }
    }
}
