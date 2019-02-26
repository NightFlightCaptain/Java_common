package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/11 9:27
 */
public class CGLibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object object;
		System.out.println("----------BEGIN---------");
		object = proxy.invokeSuper(obj,args);

		System.out.println("----------END---------");
		return object;
	}
}
