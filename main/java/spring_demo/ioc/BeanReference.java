package spring_demo.ioc;

/**
 * Author: 小栗旬
 * Date: 2019/1/29 0:12
 */
public class BeanReference {
	private String name;
	private Object bean;

	public BeanReference(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}
}
