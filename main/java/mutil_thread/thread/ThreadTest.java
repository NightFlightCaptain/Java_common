package mutil_thread.thread;

import java.util.concurrent.TimeUnit;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/24 10:24
 */
public class ThreadTest {
	public static void main(String[] args) {
		Object co = new Object();
		System.out.println(co);

		for (int i = 0; i < 1000; i++) {
			MyThread t = new MyThread("Thread" + i, co);
			t.start();
		}

		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("-----Main Thread notify-----");
//			for (int i = 0; i < 100; i++) {
				synchronized (co) {
					co.notifyAll();
				}
//			}
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Main Thread is end.");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class MyThread extends Thread {
		private String name;
		private Object co;

		public MyThread(String name, Object o) {
			this.name = name;
			this.co = o;
		}

		@Override
		public void run() {
			try {
				synchronized (co) {
					System.out.println(name + " is waiting.");
					co.wait();
					System.out.println(name + " has been notified.");
					TimeUnit.SECONDS.sleep(1);
//					co.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
