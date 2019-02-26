package spring_demo;

import java.util.Objects;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 18:55
 */
public class Car {
	private String name;
	private String length;
	private String width;
	private String height;
	private Wheel wheel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", length='" + length + '\'' +
				", width='" + width + '\'' +
				", height='" + height + '\'' +
				", wheel=" + wheel +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(name, car.name) &&
				Objects.equals(length, car.length) &&
				Objects.equals(width, car.width) &&
				Objects.equals(height, car.height) &&
				Objects.equals(wheel, car.wheel);
	}

}
