package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 *
 * @author wanhaoran
 * @date 2018年4月18日 下午4:10:33
 *
 */
public class DynamicProxy2 implements InvocationHandler {

	private Object target;

	public DynamicProxy2(Object target) {
		this.target= target;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy,Method method ,Object[] args)throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	private void before() {
		System.out.println("before222....");
	}
	
	private void after() {
		System.out.println("after222........");
	}
}
