package base.mutil_thread.lock.Sync;

import java.util.concurrent.TimeUnit;

/**
 * @author: 小栗旬
 * @Date: 2019/11/9 16:58
 */
public class SyncDemo {
    public static void main(String[] args) {
        /* 输出的结果是一定的
        * monitor阻塞时头插法插入cxq
        * notify默认唤醒策略，如果entrylist为空，进入entrylist，剩下的头插cxq
        * monitor默认出队策略，先出entrylist，如果entrylist为空，则将entrylist变为双向指向cxq
        * */
        Object lock = new Object();
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 0 start!!!!!!");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                    }
                    System.out.println("Thread 0 end!!!!!!");
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start!!!!!!");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                    }
                    System.out.println("Thread 1 end!!!!!!");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 start!!!!!!");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                    }
                    System.out.println("Thread 2 end!!!!!!");
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 3 start!!!!!!");
                synchronized (lock) {
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                    lock.notify();
                    lock.notify();
                    lock.notify();
                    System.out.println("Thread 3 end!!!!!!");
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 4 start!!!!!!");
                synchronized (lock) {
                    System.out.println("Thread 4 end!!!!!!");
                }
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 5 start!!!!!!");
                synchronized (lock) {
                    System.out.println("Thread 5 end!!!!!!");
                }
            }
        });
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 6 start!!!!!!");
                synchronized (lock) {
                    System.out.println("Thread 6 end!!!!!!");
                }
            }
        });
        t0.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        t3.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        t4.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        t5.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        t6.start();
    }
}
