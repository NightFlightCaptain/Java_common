package proxy.jdk;

/**
 * @author wanhaoran
 * @date 2018年4月18日 下午4:14:36
 */
public class Main {

    public static void main(String[] args) {


        //不实现具体类，只靠接口来实现动态带
//        Hello helloProxy = (Hello) Proxy.newProxyInstance(
//                Hello.class.getClassLoader(),
//                new Class<?>[]{Hello.class},
//                (proxy, method, args1) -> {
//                    System.out.println("什么也不是 哈哈哈");
//                    return null;
//                });
//        helloProxy.sayYourName("wan");
//        helloProxy.tellMyName();

//        Hello hello = new HelloImpl();
//        Hello newHello = (Hello) Proxy.newProxyInstance(
//                hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                new DynamicProxy2(hello)
//        );
//
//        System.out.println(newHello.toString());
        normalUse();


    }

    private static void normalUse(){
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello hello = dynamicProxy.getProxy();
        hello.sayYourName("wan");
    }
}
