package spring_demo.ioc;

public interface BeanDefinitionReader {

	void loadBeanDefinitions(String location) throws Exception;
}
