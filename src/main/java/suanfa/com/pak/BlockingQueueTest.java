package suanfa.com.pak;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        //new了两个生产者和一个消费者，同时他们共用一个queue缓存队列
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 通过线程池启动线程
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(consumer);

        // 执行5s
        Thread.sleep(5 * 1000);
        producer1.stop();
        producer2.stop();

        Thread.sleep(2000);
        // 退出Executor
        service.shutdown();
    }
}
