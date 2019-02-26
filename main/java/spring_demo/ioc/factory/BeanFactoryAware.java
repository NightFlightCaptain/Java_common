package spring_demo.ioc.factory;

public interface BeanFactoryAware {
	void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
