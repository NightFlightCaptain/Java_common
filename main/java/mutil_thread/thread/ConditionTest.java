package mutil_thread.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: 小栗旬
 * Date: 2019/1/13 21:36
 */
public class ConditionTest {
	private Lock lock = new ReentrantLock();

	private void method(){
		if (lock.tryLock()){
			try {
				System.out.println("thread name: " + Thread.currentThread().getName() + " 占据了线程");
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				System.out.println("thread name: " + Thread.currentThread().getName() + " 释放了线程");
				lock.unlock();
			}
		}else {
			System.out.println("当前lock已经被某线程占据");
		}
	}

	public static void main(String[] args) {
		ConditionTest conditionTest = new ConditionTest();

		new Thread(
				()->{
					conditionTest.method();
				},
		"thread1").start();
		new Thread(
				()->{
					conditionTest.method();
				},
		"thread2").start();
	}
}
