package mutil_thread.thread.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author: 小栗旬
 * Date: 2019/1/14 14:48
 */
public class CountDownLatchDemo {
	/*
	CountDownLatch描述的是一个线程与多个线程之间的关系，当多个线程都准备完毕之后，这一个线程就开始执行
	 */
	private static final int THREADCOUNT = 550;

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(THREADCOUNT);

		ExecutorService threadPool = Executors.newFixedThreadPool(300);

		for (int i = 0; i < THREADCOUNT; i++) {
			final int threadNum = i;
			threadPool.execute(() -> {
				try {
					test(threadNum);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					countDownLatch.countDown();
				}
			});
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println("main thread started!");
		threadPool.shutdown();
		countDownLatch.await();
		System.out.println("finish");

	}

	private static void test(int threadNum) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		System.out.println(threadNum);
		TimeUnit.SECONDS.sleep(1);
	}
}
