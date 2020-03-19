package mutil_thread.AQS;

import java.util.concurrent.*;

/**
 * Author: 小栗旬
 * Date: 2019/1/14 15:11
 */
public class CyclicBarrierDemo {
	/*
	CyclicBarrier描述的是多个线程相互之间的等待关系，当所有线程都准备完毕之后，所有线程一起开始执行下一阶段
	 */
	private static final int THREADNUM = 560;

	private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5,()->{
		System.out.println("---------------------优先执行---------------------");
	});

	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(300);
		Thread.sleep(1000);
		for (int i = 0; i < THREADNUM; i++) {
			final int threadNum = i;
			threadPool.execute(() -> {
				try {
					test(threadNum);
					System.out.println("thread " + threadNum + " want to do something...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		threadPool.shutdown();
	}

	private static void test(int threadNum) {
		System.out.println("thread " + threadNum + " is ready!");
		try {
			CYCLIC_BARRIER.await(2000, TimeUnit.SECONDS);
		} catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
			e.printStackTrace();
		}
//		System.out.println("thread " + threadNum + " is finished!");
	}
}
