package code.extend.example;

/**
 * Author: 小栗旬
 * Date: 2018/12/26 13:57
 */
public class Student extends People {
	People people = new People();

	public Student(String name) {
//		this.name = name;
//		System.out.println("子类的构造方法");
//		say();

		people.protectedName = name;
		people.name = name;

		super.protectedName = name;
		super.name = name;

		people.defaultMethod();
		people.protectedMethod();
		super.protectedMethod();
		super.defaultMethod();
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