package spring_demo.ioc2;

public interface BeanDefinitionReader {
	void loadBeanDefinitions(String location) throws Exception;
}
