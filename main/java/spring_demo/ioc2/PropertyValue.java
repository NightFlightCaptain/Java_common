package spring_demo.ioc2;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 15:47
 */
public class PropertyValue {
	/**
	 * 属性的名称
	 */
	private String name;
	/**
	 * 属性的值，如果是基本类型，那么就是实际存储的值；如果是引用类型，那么存储的是Reference
	 */
	private Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public PropertyValue() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
