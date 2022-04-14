package suanfa.com.pak;

public class MainTest {
    int i = 1;   //i和istrue作为多线程的共享数据
    boolean istrue = false;

    public static void main(String[] args) {
        MainTest main = new MainTest();
        ThreadA a = new ThreadA(main);
        ThreadB b = new ThreadB(main);
        Thread threada = new Thread(a);
        Thread threadb = new Thread(b);
        threada.start();
        threadb.start();

    }}

class ThreadA implements Runnable {
    MainTest main;

    public ThreadA(MainTest main) {
        this.main = main;
    }

    public void run() {
        while (main.i <= 10) {
            synchronized (main) { // 必须要用一把锁对象，这个对象是main
                if (!main.istrue) {
                    try {
                        main.wait(); // 操作wait()函数的必须和锁是同一个
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("奇数：" + main.i);
                    main.i++;
                    main.istrue = false;
                    main.notifyAll();
                }
            }}}}

class ThreadB implements Runnable {
    MainTest main;

    public ThreadB(MainTest main) {
        this.main = main;
    }

    public void run() {
        while (main.i <= 10) {
            synchronized (main) { // 必须要用一把锁对象，这个对象是main
                if (main.istrue) {
                    try {
                        main.wait(); // 操作wait()函数的必须和锁是同一个
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("偶数：" + main.i);
                    main.i++;
                    main.istrue = true;
                    main.notifyAll();
                }
            }}}
}
