package base.code.extend.example;

/**
 * Author: 小栗旬
 * Date: 2018/12/26 13:57
 */
public class Student extends People {
	People people = new People();


	public Student() {
		System.out.println("子类构造方法");
	}

	public Student(String name) {

		people.protectedName = name;
		people.name = name;

		super.protectedName = name;
		super.name = name;

		people.defaultMethod();
		people.protectedMethod();
		super.protectedMethod();
		super.defaultMethod();
	}

	static {
		System.out.println("子类的static代码块");
	}

	{
		System.out.println("子类的非static代码块");
	}

//	public void say() {
//		System.out.println("子类的方法" + name);
//	}
//
//	public void StudentSay() {
//		System.out.println("Student Say.....");
//	}
//
//	public static void sayStatic() {
//		System.out.println("字类的静态方法");
//	}
}