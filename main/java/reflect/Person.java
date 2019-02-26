package reflect;

import java.util.Objects;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/10 11:33
 */
public class Person implements Swim{
	private String name;

	@Override
	public void swim() {
		System.out.println("i can swim");
	}

	public void sayHello(){
		System.out.println("hello");
	}

	private void sayHello(String string){
		System.out.println("hello " + string);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {

		return Objects.hash(name);
	}
}
