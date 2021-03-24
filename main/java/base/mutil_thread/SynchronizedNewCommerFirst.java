package base.mutil_thread;

import java.util.concurrent.*;

/**
 * @author: 小栗旬
 * @Date: 2021/3/24 20:16
 */
public class SynchronizedNewCommerFirst {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new ThreadFactory() {
            int i =0;
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("thread"+i++);
                return thread;
            }
        });
        SynchronizedNewCommerFirst newCommerFirst = new SynchronizedNewCommerFirst();
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.submit(() -> {
                try {
                    newCommerFirst.dosome();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    private synchronized void dosome() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(1);
    }

}
