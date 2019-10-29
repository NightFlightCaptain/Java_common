package springdemo.factory;

import springdemo.BeanDefinition;
import springdemo.BeanReference;
import springdemo.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 11:30
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    void applyPropertyValue(BeanDefinition beanDefinition, Object bean) throws Exception {
        for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
            String name = pv.getName();
            Object value = pv.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getName());
            }

            try {
                Method method = bean.getClass().getDeclaredMethod(
                        "set" + name.substring(0, 1).toUpperCase() + name.substring(1), value.getClass());
                method.invoke(bean,value);
            }catch (NoSuchMethodException e){
                Field field = bean.getClass().getDeclaredField(name);
                field.setAccessible(true);
                field.set(bean,value);
            }
        }
    }
}
