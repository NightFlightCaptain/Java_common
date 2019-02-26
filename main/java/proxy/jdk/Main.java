package proxy.jdk;

/**
 *
 *@author wanhaoran
 *@date 2018年4月18日 下午4:14:36
 *
 */
public class Main {

	public static void main(String[] args) {

		//不实现具体类，只靠接口来实现动态带
//		Hello helloProxy = (Hello) Proxy.newProxyInstance(
//				Hello.class.getClassLoader(),
//				new Class<?>[]{Hello.class}, new InvocationHandler() {
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						System.out.println("什么也不是 哈哈哈");
//						return new Object();
//					}
//				});
//		helloProxy.sayYourName("wan");
//		helloProxy.tellMyName();

		DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
		Hello helloProxy = dynamicProxy.getProxy();


//		DynamicProxy2 dynamicProxy2 = new DynamicProxy2(dynamicProxy.getProxy());
//		Hello helloProxy = dynamicProxy2.getProxy();
		helloProxy.sayYourName("万浩然");
		helloProxy.toString();
		
	}
}
