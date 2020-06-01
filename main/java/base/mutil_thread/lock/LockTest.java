package base.mutil_thread.lock;
/**
 * @author wanhaoran
 * @date 2018年5月15日 下午5:16:08
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private Lock lock = new ReentrantLock();

    private void lockMethod() {
        try {
            lock.lock();
            System.out.println("thread name: " + Thread.currentThread().getName() + " 获得了锁");
            while (true){

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("thread name: " + Thread.currentThread().getName() + " 释放了锁");
            lock.unlock();
        }
    }

    private void tryLockMethod() {
        if (lock.tryLock()) {
            try {
                System.out.println("thread name: " + Thread.currentThread().getName() + " 获得了锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("thread name: " + Thread.currentThread().getName() + " 释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println("i'm " + Thread.currentThread().getName() + " 有人正占用这锁");
        }

    }

    private void lockInterrupt(int i) {
        System.out.println(Thread.currentThread().getName() + "start.");
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " lock");
            TimeUnit.SECONDS.sleep(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " unlock");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        Thread thread1 = new Thread(() -> {
            lockTest.lockMethod();
        }, "t1");
        TimeUnit.SECONDS.sleep(1);
        Thread thread2 = new Thread(() -> {
            lockTest.lockMethod();
        }, "t2");

        thread1.start();
        thread2.start();

        TimeUnit.SECONDS.sleep(2);
        thread2.interrupt();
    }
}
