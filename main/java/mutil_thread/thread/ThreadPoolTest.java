package mutil_thread.thread;


import java.util.concurrent.*;

/**
 * @author wanhaoran
 * @date 2018年5月2日 下午4:56:10
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ExecutorService service = new ThreadPoolExecutor(10, 100, 2000,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(30), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"test"+1);
            }
        });

    }
}
