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
public class DynamicProxy implements InvocationHandler {

	private Object target;

	public DynamicProxy(Object target) {
		this.target= target;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy,Method method ,Object[] args)throws Throwable {
//		System.out.println("dynamic proxy class:" + proxy.getClass());
//		System.out.println("method:" + method.getName());
//		System.out.println("args:" + Arrays.toString(args));

		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	private void before() {
		System.out.println("before....");
	}
	
	private void after() {
		System.out.println("after........");
	}
}
