package mutil_thread.thread;

import java.util.concurrent.TimeUnit;

/**
 * Author: 小栗旬
 * Date: 2019/2/16 14:31
 */
public class VolatileDemo {
	static int k =10;
	public static void main(String[] args) {
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			VolatileDemo.k = 20;
			System.out.println(VolatileDemo.k);
		}).start();

		new Thread(()->{
			System.out.println(VolatileDemo.k);
		}).start();
	}
}
