package base.proxy.jdk.simpleproxy;

import base.proxy.jdk.Hello;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/10 15:36
 */
public class SimpleProxy implements Hello {
	private Hello proxyId;

	public SimpleProxy(Hello proxyId) {
		this.proxyId = proxyId;
	}

	@Override
	public String tellMyName() {
		return null;
	}

	@Override
	public String sayYourName(String name) {
		System.out.println("base.proxy sayYourName");
		proxyId.sayYourName(name);
		return name;
	}
}
