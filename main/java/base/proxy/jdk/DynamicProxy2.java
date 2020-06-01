package base.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * @author wanhaoran
 * @date 2018年4月18日 下午4:10:33
 */
public class DynamicProxy2 implements InvocationHandler {


    private Object object;

    public DynamicProxy2(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        if ("toString".equals(method.getName())) {
            return proxy;
        }
        return method.invoke(object, args);
    }

    private void before() {
        System.out.println("before...");
    }

}
