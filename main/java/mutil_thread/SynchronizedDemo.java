package mutil_thread;

/**
 * @author: 小栗旬
 * @Date: 2020/3/9 21:23
 */
public class SynchronizedDemo {
    Integer i = 3;

    public void doSome(){
        Thread thread = new Thread(() -> {
            synchronized (i){
                System.out.println("11");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        i = 2;
        Thread thread1 = new Thread(()->{
            synchronized (i){
                System.out.println("11");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.doSome();
    }
}
