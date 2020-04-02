package algorithm.realExam.alibaba;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AliTest3 {
    public static void main(String[] args) {
        AliTest3 test = new AliTest3();
        test.doSome();
    }

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    private void doSome() {


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            int num = 2;
            while (num <= 100) {
                if (atomicInteger.get() == 0) {
                    System.out.println("Thread B:" + num);
                    num += 2;
                    atomicInteger.set(1);
                }
            }
        });
        executorService.submit(() -> {
            int num = 1;
            while (num < 100) {
                if (atomicInteger.get() == 1) {
                    System.out.println("Thread A:" + num);
                    num += 2;
                    atomicInteger.set(0);
                }
            }
        });
        executorService.shutdown();
    }
}
