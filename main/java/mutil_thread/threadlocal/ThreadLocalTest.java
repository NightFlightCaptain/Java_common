package mutil_thread.threadlocal;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/9 16:26
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("wan");
	}
}
