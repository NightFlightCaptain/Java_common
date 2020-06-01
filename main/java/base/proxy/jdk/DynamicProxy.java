package base.proxy.jdk;

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

	/**
	 * 实际上，Proxy.newProxyInstance创造出一个新的Proxy0类，这个类继承自Proxy，内部有一个InvocationHandler。
     * 这个新的Proxy0类的对象实现了给定接口，具体的实现方法就是通过InvocationHandler来执行
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),this);
	}
	
	@Override
	public Object invoke(Object proxy,Method method ,Object[] args)throws Throwable {
//		System.out.println("dynamic base.proxy class:" + base.proxy.getClass());
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
