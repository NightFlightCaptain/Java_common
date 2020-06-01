package base.proxy.jdk.simpleproxy;

import base.proxy.jdk.Hello;
import base.proxy.jdk.HelloImpl;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/10 15:38
 */
public class SimpleMain {
	public static void main(String[] args) {
		comsume(new HelloImpl());
		System.out.println("-----------------");
		comsume(new SimpleProxy(new HelloImpl()));
	}

	public static void comsume(Hello iface){
		iface.sayYourName("wan");
	}
}
