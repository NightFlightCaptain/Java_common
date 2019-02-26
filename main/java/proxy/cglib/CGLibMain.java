package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/11 9:32
 */
public class CGLibMain {

	public static void main(String[] args) {
		CGLibProxy CGProxy = new CGLibProxy();
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(CGProxy);
		enhancer.setSuperclass(HelloCg.class);
		HelloCg helloCg = (HelloCg) enhancer.create();
		helloCg.sayYourName("wan");

	}
}
