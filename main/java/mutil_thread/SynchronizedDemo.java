package mutil_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author: 小栗旬
 * @Date: 2020/3/9 21:23
 */
public class SynchronizedDemo {
    Integer i = 3;

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    public void doSome(){
        Object object = new Object();
        Future future= executorService.submit(()->{
            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (!Thread.interrupted()){

                }
                System.out.println("stop 1");
            }
        });


        executorService.submit(()->{
            synchronized (object){
                System.out.println("thread2 start");
                object.notify();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.doSome();
    }
}
