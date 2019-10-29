package springdemo.factory;

import springdemo.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 11:16
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private final List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean with name :" + name);
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    private Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBean(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValue(beanDefinition,bean);
        return bean;
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = beanDefinition.getBeanClass().newInstance();
        return bean;
    }

    abstract void applyPropertyValue(BeanDefinition beanDefinition,Object bean) throws Exception;

    public void registerBeanDefintions(String name,BeanDefinition beanDefinition){
        getBeanDefinitionMap().put(name,beanDefinition);
        getBeanDefinitionNames().add(name);
    }

    public Map<String, BeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    public List<String> getBeanDefinitionNames() {
        return beanDefinitionNames;
    }
}
