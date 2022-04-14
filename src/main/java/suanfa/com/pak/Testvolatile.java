package suanfa.com.pak;

public class Testvolatile {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Testvolatile test = new Testvolatile();
        for(int i=0;i<2;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<7;j++)
                        test.increase();
                };
            }.start();
        }

        //while(Thread.activeCount()>1)  //保证前面的线程都执行完
        //    Thread.yield();
        System.out.println(test.inc);
    }
}
