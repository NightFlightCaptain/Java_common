package springdemo;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 10:42
 */
public class BeanDefinition {
    private String className;
    private Class beanClass;
    private Object bean;
    private PropertyValues propertyValues = new PropertyValues();


    public BeanDefinition() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className)  {
        this.className = className;
        try {
            this.beanClass = Class.forName(className);
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

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
