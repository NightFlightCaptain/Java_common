package mutil_thread.lock;
/**
 * @author wanhaoran
 * @date 2018年5月15日 下午5:16:08
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private Lock lock = new ReentrantLock();

	/*
		 lock的方法
		private void method(Thread thread) {
			lock.lock();
			try {
				System.out.println("thread name: " + thread.getName()+" 获得了锁");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("thread name: " + thread.getName()+" 释放了锁");
				lock.unlock();
			}
		}
	*/

	private void method(Thread thread) {
		if (lock.tryLock()) {
			try {
				System.out.println("thread name: " + thread.getName() + " 获得了锁");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("thread name: " + thread.getName() + " 释放了锁");
				lock.unlock();
			}
		} else {
			System.out.println("i'm " + Thread.currentThread().getName() + " 有人正占用这锁");
		}

	}

	private void locktest(int i) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "start.");
		lock.lockInterruptibly();
		try {
			TimeUnit.SECONDS.sleep(i);
			System.out.println(Thread.currentThread().getName() + " end lock and sleep");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		LockTest lockTest = new LockTest();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lockTest.locktest(5);
				} catch (InterruptedException e) {
					System.out.println("interrupted exception 1 处出现的错误");
				}
			}
		}, "t1");
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lockTest.locktest(7);
				} catch (InterruptedException e) {
					System.out.println("interrupted exception 2 处出现的错误");
				}
			}
		}, "t2");

		thread1.start();
		thread2.start();

		TimeUnit.SECONDS.sleep(2);
		thread2.interrupt();
	}
}
