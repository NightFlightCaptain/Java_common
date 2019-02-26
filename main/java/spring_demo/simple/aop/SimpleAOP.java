package spring_demo.simple.aop;

import java.lang.reflect.Proxy;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 20:42
 */
public class SimpleAOP {
	public static Object getProxy(Object bean, Advice advice) {
		return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
				bean.getClass().getInterfaces(), advice);
	}
}
