package mutil_thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/9 16:26
 */
public class ThreadLocalTest {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.submit(() -> {
            test.threadLocal.set(new Integer(11));
            test.threadLocal2.set(new Integer(12));
            System.out.println("11");
        });
        executorService.submit(() -> {
            test.threadLocal.set(new Integer(22222226));
            test.threadLocal2.set(new Integer(2222227));
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("22");
                test.threadLocal2.remove();
                System.out.println("222");
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1000);
        executorService.shutdown();
        test.threadLocal = null;
        System.out.println("main thread");
        System.gc();
    }
}
