package spring_demo.ioc2.factory;

public interface BeanFactory {
	Object getBean(String beanID) throws Exception;
}
