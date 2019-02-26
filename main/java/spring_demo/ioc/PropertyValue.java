package spring_demo.ioc;

/**
 * Author: 小栗旬
 * Date: 2019/1/29 0:03
 */
public class PropertyValue {
	private final String name;
	private final Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "PropertyValue{" +
				"name='" + name + '\'' +
				", value=" + value +
				'}';
	}
}
