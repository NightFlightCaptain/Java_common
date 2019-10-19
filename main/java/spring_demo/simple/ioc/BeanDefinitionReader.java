package spring_demo.simple.ioc;

/**
 * @author: 小栗旬
 * @Date: 2019/10/17 15:07
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
