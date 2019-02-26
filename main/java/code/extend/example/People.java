package code.extend.example;

/**
 * Author: 小栗旬
 * Date: 2018/12/26 13:55
 */
public class People {
	String name;
	private String privateName;
	public String publicName;
	protected String protectedName;

	static int age;

	private void privateMethod(){

	}
	protected void protectedMethod() throws RuntimeException{

	}

	void defaultMethod(){

	}

	public People() {
		System.out.println("父类的构造方法");
		say();
	}

	public final void say() {
		age = 1;
		System.out.println(age);
		System.out.println("父类的方法");
	}

	static {
		System.out.println("父类的static");
	}

	{
		System.out.println("父类的非static");
	}

	public static void sayStatic() {
		System.out.println("父类的静态方法");
	}

}
