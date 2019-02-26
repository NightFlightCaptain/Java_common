package code.extend.example2;

import code.extend.example.People;

/**
 * Author: 小栗旬
 * Date: 2018/12/26 14:01
 */
public class Teacher extends People{
	People people = new People();
	public Teacher(String name){


//		people.protectedName = name;
//		people.name = name;

		super.protectedName = name;
//		super.name = name;

		super.protectedMethod();
	}

	@Override
	protected void protectedMethod() throws IllegalStateException {
		super.protectedMethod();


	}
}
