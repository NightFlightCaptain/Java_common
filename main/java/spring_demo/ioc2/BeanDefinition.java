package spring_demo.ioc2;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 15:46
 */
public class BeanDefinition {
	private Object bean;
	private String beanClassName;
	private Class beanClass;
	private PropertyValues propertyValues;

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

}
