package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 20:38
 */
public class StreamDemo {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Jack",92));
		students.add(new Student("Tom",23));
		students.add(new Student("Joe",68));
		students.add(new Student("Andy",74));
//		students.add(new Student("Candy",55));

		System.out.println(students.stream().mapToInt(Student::getScore).sum());

		Long totalScore = students.stream().map(Student::getScore)
				.map(Long::valueOf)
				.reduce((a,b)->{
					System.out.println(a);
					System.out.println(b);
					System.out.println("----");
					return a+b;
				}).get();



		System.out.println(totalScore);
	}
}

class Student{
	String name;
	int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", score=" + score +
				'}';
	}
}
