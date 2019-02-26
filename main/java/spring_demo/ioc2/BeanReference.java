package spring_demo.ioc2;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 15:49
 */
public class BeanReference {
	private String name;
	private Object ref;

	public BeanReference(Object ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getRef() {
		return ref;
	}

	public void setRef(Object ref) {
		this.ref = ref;
	}
}
