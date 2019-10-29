package springdemo;

import springdemo.context.ClassPathXmlApplicaitonContext;
import springdemo.model.Car;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 11:52
 */
public class SprintMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicaitonContext context = new ClassPathXmlApplicaitonContext("toy-spring.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
}
