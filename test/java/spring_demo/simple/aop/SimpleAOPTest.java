package spring_demo.simple.aop;

import org.junit.jupiter.api.Test;
import spring_demo.HelloService;
import spring_demo.HelloServiceImpl;

class SimpleAOPTest {

	@Test
	void getProxy() throws Exception {
		HelloServiceImpl helloService = new HelloService();

		MethodInvocation methodInvocation = new MethodInvocation() {
			@Override
			public void invoke() {
				System.out.println("log task ....");
			}
		};

		BeforeAdvice beforeAdvice = new BeforeAdvice(helloService,()->System.out.println("log task ...."));

		HelloServiceImpl helloServiceProxy = (HelloServiceImpl) SimpleAOP.getProxy(helloService,beforeAdvice);
		helloServiceProxy.sayHelloWorld();
	}
}