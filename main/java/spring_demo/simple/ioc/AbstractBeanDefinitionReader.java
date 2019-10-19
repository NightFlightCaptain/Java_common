package spring_demo.simple.ioc;

import spring_demo.simple.ioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 小栗旬
 * @Date: 2019/10/17 15:08
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        registry = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
