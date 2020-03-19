import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.doSome();
    }

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    private void doSome() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            while (atomicInteger.get() <= 100) {
                synchronized (atomicInteger) {
                    if ((atomicInteger.get() & 1) == 0) {
                        System.out.println("Thread B:" + atomicInteger.getAndIncrement());
                    }
                }
            }
        });
        executorService.submit(() -> {
            while (atomicInteger.get() < 100) {
                synchronized (atomicInteger) {
                    if ((atomicInteger.get() & 1) == 1) {
                        System.out.println("Thread A:" + atomicInteger.getAndIncrement());
                    }
                }
            }
        });
        executorService.shutdown();
    }
}
