package springdemo;

import springdemo.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 10:49
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String,BeanDefinition> register;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        register = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegister() {
        return register;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
