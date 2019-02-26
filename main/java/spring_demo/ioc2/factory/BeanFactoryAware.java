package spring_demo.ioc2.factory;

public interface BeanFactoryAware {
	void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
