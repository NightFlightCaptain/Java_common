package spring_demo.ioc.xml;

import org.junit.jupiter.api.Test;
import spring_demo.model.Car;
import spring_demo.model.Wheel;
import spring_demo.simple.ioc.XmlBeanFactory;

class XmlBeanFactoryTest {

	@Test
	void getBean() throws Exception{
		System.out.println("----------IOC Test----------");
		XmlBeanFactory bf = new XmlBeanFactory("toy-spring.xml");

		Wheel wheel = (Wheel)bf.getBean("wheel");
		System.out.println(wheel);

		Car car = (Car)bf.getBean("car");
		System.out.println(car);


	}
}