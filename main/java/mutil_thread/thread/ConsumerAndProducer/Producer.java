package mutil_thread.thread.ConsumerAndProducer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: 小栗旬
 * Date: 2019/1/13 21:57
 */
public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		PCData pcData = null;
		Random random = new Random();

		System.out.println("start producerint id: " + Thread.currentThread().getId());
		try {
			while (isRunning) {
				Thread.sleep(random.nextInt(SLEEPTIME));
				pcData = new PCData(count.incrementAndGet());
				System.out.println(pcData + "加入队列");
				if (!queue.offer(pcData,2,TimeUnit.SECONDS)) {
					System.out.println(pcData + "加入队列失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void stop() {
		isRunning = false;
	}
}
