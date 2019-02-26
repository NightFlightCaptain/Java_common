package reflect;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/9 10:22
 */
public class ClassNeedReflect {
	private String fieldReflect;

	{
		System.out.println("nothing happens");
	}

	static {
		System.out.println("static block");
	}
	private ClassNeedReflect() {
		System.out.println("私有构造方法");
	}

	public void methodReflect(){
		System.out.println("方法");
	}
}
