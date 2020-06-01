package base.mutil_thread.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Author: 小栗旬
 * Date: 2019/1/14 14:34
 */
public class SemaphoreDemo1 {
	/*
	Semaphore表示的是资源数，即最多可以让多少线程使用
	 */
	private static final int THREAD_COUNT = 550;

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(300);

		final Semaphore semaphore = new Semaphore(3);

		for (int i = 0; i < THREAD_COUNT; i++) {
			final int threadNum = i;
			threadPool.execute(() -> {
				try {
					semaphore.acquire();
					//如果acquire执行不被许可，那么就回阻塞
					//tryAcquire()会直接放回false
					test(threadNum);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		threadPool.shutdown();
		System.out.println("finish");
	}

	private static void test(int threadNum) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		System.out.println(threadNum);
		TimeUnit.SECONDS.sleep(1);
	}
}
