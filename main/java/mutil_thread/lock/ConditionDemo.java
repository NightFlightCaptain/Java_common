package mutil_thread.lock;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 小栗旬
 * @Date: 2019/11/11 21:10
 */
public class ConditionDemo {
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
                    System.out.println("produce :" + i);
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
                    System.out.println("consume :" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class DataList {
        LinkedList<Integer> linkedList = new LinkedList<>();
        private final Lock lock = new ReentrantLock();
        Condition fullCondition = lock.newCondition();
        Condition emptyCondition = lock.newCondition();

        public void add(Integer integer) throws InterruptedException {
            lock.lock();
            try {
                while (linkedList.size()>=20){
                    fullCondition.await();
                }
                linkedList.add(integer);
                System.out.println("produce:" + integer);
                emptyCondition.signal();
            }finally {
                lock.unlock();
            }
        }

        public Integer get() throws InterruptedException {
            lock.lock();
            try {
                while (linkedList.isEmpty()){
                    emptyCondition.await();
                }
                Integer integer = linkedList.getFirst();
                System.out.println("consume:" + integer);
                fullCondition.signal();
                return integer;
            }finally {
                lock.unlock();
            }
        }
    }
}
