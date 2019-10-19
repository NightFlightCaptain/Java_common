package spring_demo.simple.ioc;

import spring_demo.simple.ioc.io.ResourceLoader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 小栗旬
 * @Date: 2019/10/16 23:48
 */
public class XmlBeanFactory {
    private Map<String, BeanDefinition> beans = new HashMap<>();
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private XmlBeanDefinitionReader xmlBeanDefinitionReader;

    public XmlBeanFactory(String location) throws Exception {
        xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(location);
        registerBeanDefinitions();
    }

    private void registerBeanDefinitions() {
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beans.put(entry.getKey(), entry.getValue());
            beanDefinitions.add(entry.getValue());
        }
    }

    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beans.get(name);
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = createBean(beanDefinition);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = beanDefinition.getBeanClass().newInstance();
        beanDefinition.setBean(bean);
        applyPropertyValues(beanDefinition, bean);
        return bean;
    }

    private void applyPropertyValues(BeanDefinition beanDefinition, Object bean) throws Exception {
        for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
            Object value = pv.getValue();
            if (value instanceof BeanReference) {
                value = getBean(pv.getName());
            }
            try {
                Method method = bean.getClass().getDeclaredMethod("set"
                        + pv.getName().substring(0, 1).toUpperCase()
                        + pv.getName().substring(1), value.getClass());
                method.setAccessible(true);
                method.invoke(bean, value);

            } catch (NoSuchMethodException e) {
                Field declaredField = beanDefinition.getBeanClass().getDeclaredField(pv.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
