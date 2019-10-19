package spring_demo.simple.ioc;

/**
 * @author: 小栗旬
 * @Date: 2019/10/16 23:27
 */
public class BeanDefinition {
    private String className;
    private Class beanClass;
    private Object bean;
    private PropertyValues propertyValues = new PropertyValues();



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        try {
            beanClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

}
