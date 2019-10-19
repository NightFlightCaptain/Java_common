package spring_demo.model;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 20:43
 */
public class HelloService implements HelloServiceImpl {

	@Override
	public void sayHelloWorld() {
		System.out.println("hello world!");
	}
}
