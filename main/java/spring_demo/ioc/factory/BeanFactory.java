package spring_demo.ioc.factory;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 23:59
 */
public interface BeanFactory {
	Object getBean(String beanId) throws Exception;
}
