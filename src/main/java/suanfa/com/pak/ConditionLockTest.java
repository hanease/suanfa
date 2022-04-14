package suanfa.com.pak;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConditionLockTest {

    public static void main(String[] args){

        /*//相当于仓库
        Depot depot=new Depot();

        //创建两个生产者一个消费者
        Producer producer1=new Producer(depot);
        Producer producer2=new Producer(depot);
        Consumer consumer1=new Consumer(depot);

        //采用线程池方式
        Executor executors= Executors.newFixedThreadPool(5);
        executors.execute(producer1);
        executors.execute(producer2);
        executors.execute(consumer1);*/
    }
}

/*//生产者
class Producer implements  Runnable {

    Depot depot;
    public Producer(Depot depot){
        this.depot=depot;
    }
    public void  run(){
        while(true){
            depot.prod();
        }
    }
}

//消费者
class Consumer implements  Runnable{

    Depot depot;
    public Consumer(Depot depot){
        this.depot=depot;
    }
    public void run(){
        while(true){
            depot.consum();
        }
    }
}*/
