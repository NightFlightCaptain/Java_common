package mutil_thread.consumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author: 小栗旬
 * @Date: 2019/11/11 22:14
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        DataList dataList = new DataList();
        new Thread(new Producer(dataList)).start();
        new Thread(new Producer(dataList)).start();
        new Thread(new Producer(dataList)).start();

        new Thread(new Comsumer(dataList)).start();
        new Thread(new Comsumer(dataList)).start();
        new Thread(new Comsumer(dataList)).start();

    }

    static class Producer implements Runnable {
        DataList dataList;

        public Producer(DataList dataList) {
            this.dataList = dataList;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                Integer i = random.nextInt(100);
                try {
                    Thread.sleep(random.nextInt(1000));
                    dataList.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Comsumer implements Runnable {
        DataList dataList;

        public Comsumer(DataList dataList) {
            this.dataList = dataList;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(1000));
                    int i = dataList.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class DataList {
        LinkedList<Integer> linkedList = new LinkedList<>();
        private final Object object = new Object();

        public void add(Integer integer) throws InterruptedException {
            synchronized (object) {
                while (linkedList.size() >= 5) {
                    object.wait();
                }
                linkedList.add(integer);
                System.out.println("produce:" + integer);
                object.notify();
            }
        }

        public Integer get() throws InterruptedException {
            synchronized (object) {
                while (linkedList.isEmpty()) {
                    object.wait();
                }
                int i = linkedList.pollFirst();
                System.out.println("consume:" + i);
                object.notify();
                return i;
            }
        }
    }
}
