package base.mutil_thread.lock.Sync;

import base.reflect.Person;

import java.util.concurrent.TimeUnit;

/**
 * @author: 小栗旬
 * @Date: 2019/11/14 10:37
 */
public class LockClass {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            Class c = Person.class;
            synchronized (c){
                while (true){

                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        Person person =new Person();
        System.out.println(person);
    }
}
