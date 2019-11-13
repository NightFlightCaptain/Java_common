package mutil_thread.lock.Sync;

import java.util.concurrent.TimeUnit;

/**
 * @author: 小栗旬
 * @Date: 2019/11/12 10:07
 */
public class InterruptDemo {
    //interrupt 会使得sleep，wait，join的线程发出错误
    //但是当线程处于synchronized的时候不会报错

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " get the lock");
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " lock wait");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " get the lock");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " unlock the lock");
                }
            }
        });

        thread1.start();
        TimeUnit.SECONDS.sleep(2);
        thread2.start();
        TimeUnit.SECONDS.sleep(8);
        thread1.interrupt();

    }
}
