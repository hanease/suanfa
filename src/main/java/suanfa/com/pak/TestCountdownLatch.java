package suanfa.com.pak;

import java.util.concurrent.CountDownLatch;

public class TestCountdownLatch {

    public static void main(String[] args) {
        runDAfterABC();
    }

    private static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D开始工作前先等ABC工作完成");
                try {

                    //因为worker初始值为3，所以在不等于0之前一直处于等待状态
                    countDownLatch.await();
                    System.out.println("ABC工作完成，D开始工作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (char threadName='A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + "正在工作.....");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + "完成工作......");

                    //每调用一次worker值减一
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
