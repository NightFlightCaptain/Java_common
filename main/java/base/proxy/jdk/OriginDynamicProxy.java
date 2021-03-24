package base.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: 小栗旬
 * @Date: 2021/3/19 18:11
 */
public class OriginDynamicProxy {
    public static void main(String[] args) {
        OriginDynamicProxy proxy = new OriginDynamicProxy();
        proxy.testDynamicProxy().sayYourName("2");
    }

    private Hello testDynamicProxy() {
        Hello hello = new HelloImpl();
        return (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("begin---");
                Object result = method.invoke(hello, args);
                return result;
            }
        });
    }
}
