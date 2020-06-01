package base.reflect;

/**
 * Copyright(C) 2018-2018
 * Author: wanhaoran
 * Date: 2018/6/10 11:35
 */
public class Student extends Person {
	private String school;

	private Student(String school){
		this.school = school;
	}

	private void sayMySchool(){
		System.out.println(school);
	}
	private void sayMySchool(String schoolName){
		System.out.println(school+" "+schoolName);
	}

}
