package spring_demo.ioc2;


public interface BeanDefinitionReader {
	/**
	 * 根据位置加载BeanDefinitions
	 * @param location 位置
	 * @throws Exception
	 */
	void loadBeanDefinitions(String location) throws Exception;
}
