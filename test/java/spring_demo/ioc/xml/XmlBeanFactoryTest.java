package spring_demo.ioc.xml;

import org.junit.jupiter.api.Test;
import spring_demo.Car;
import spring_demo.Wheel;

class XmlBeanFactoryTest {

	@Test
	void getBean() throws Exception{
		System.out.println("----------IOC Test----------");
		String location = getClass().getClassLoader().getResource("toy-spring.xml").getFile();
		XmlBeanFactory bf = new XmlBeanFactory(location);

		Wheel wheel = (Wheel)bf.getBean("wheel");
		System.out.println(wheel);

		Car car = (Car)bf.getBean("car");
		System.out.println(car);


	}
}