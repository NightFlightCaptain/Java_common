package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/9 10:22
 */
public class ReflectMain {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(99999);
		arrayList.getClass().getMethod("add",Object.class).invoke(arrayList,"aa");


		//		method2();
	}

	private static void method2() throws Exception{
		String[] strings = new String[]{"wan","hao","ran"};
		Class<?> clazz = strings.getClass();
		System.out.println(clazz);
		System.out.println(clazz.getComponentType());
	}

	private void method1() throws Exception {
		Class<Student> clazz = Student.class;
		Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		constructor.getGenericParameterTypes();
		Student student = constructor.newInstance("xiaogan");

		Method method  = clazz.getDeclaredMethod("sayMySchool",String.class);
		method.setAccessible(true);

		Field field = clazz.getDeclaredField("school");
		field.setAccessible(true);
		field.set(student,"whan");

		Class<?> superClass = clazz.getSuperclass();
		System.out.println(superClass);

		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> theInterface:interfaces){
			System.out.println(theInterface);
		}
		method.invoke(student,"gaoji");
	}
}
