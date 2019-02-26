package mutil_thread.thread.ConsumerAndProducer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Author: 小栗旬
 * Date: 2019/1/13 21:57
 */
public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("start consuming id: " + Thread.currentThread().getId());
		Random random = new Random();

		try {
			while (!Thread.interrupted()) {
				PCData pcData = queue.take();
				if (pcData!=null) {
					System.out.println("取出了pcdata"+pcData.getIntData());
				}
				Thread.sleep(random.nextInt(SLEEPTIME));
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
