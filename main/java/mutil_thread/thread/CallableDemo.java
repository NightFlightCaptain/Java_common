package mutil_thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Author: 小栗旬
 * Date: 2019/1/14 17:30
 */
public class CallableDemo implements Callable<String> {

	private String str;

	public CallableDemo(String str){
		this.str = str;
	}

	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("call thread print something");
		return this.str + " append some chars and return!";
	}

	public static void main(String[] args) {
		CallableDemo callableDemo = new CallableDemo("shaolike");

		FutureTask<String> futureTask = new FutureTask<>(callableDemo);
		new Thread(futureTask).start();

		String re = null;
//		try {
//			re = futureTask.get();
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
		System.out.println("main thread print something");
		System.out.println(re);

	}
}
