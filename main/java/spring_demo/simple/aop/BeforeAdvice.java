package spring_demo.simple.aop;

import java.lang.reflect.Method;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 20:40
 */
public class BeforeAdvice implements Advice {

	private Object bean;
	private MethodInvocation methodInvocation;

	public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
		this.bean = bean;
		this.methodInvocation = methodInvocation;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		methodInvocation.invoke();
		return method.invoke(bean,args);
	}
}
