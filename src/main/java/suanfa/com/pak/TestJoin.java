package suanfa.com.pak;

public class TestJoin {
    public static void main(String[] args) {
        demo2();
    }

    private static void demo2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
    }

    private static void printNumber(String threadName) {
        int i=0;
        while (i++ < 3) {
            System.out.println(threadName + "print:" + i);
        }
    }
}
