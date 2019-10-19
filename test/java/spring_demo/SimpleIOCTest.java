package spring_demo;

import org.junit.Test;
import spring_demo.model.Car;
import spring_demo.model.Wheel;
import spring_demo.simple.SimpleIOC;

public class SimpleIOCTest {
	@Test
	public void getBean() throws Exception{
		String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
		SimpleIOC bf = new SimpleIOC(location);

		Wheel wheel = (Wheel) bf.getBean("wheel");
		System.out.println(wheel);
		Car car = (Car) bf.getBean("car");
		System.out.println(car);
	}
}