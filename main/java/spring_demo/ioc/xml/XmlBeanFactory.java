package spring_demo.ioc.xml;

import spring_demo.ioc.BeanDefinition;
import spring_demo.ioc.BeanPostProcessor;
import spring_demo.ioc.BeanReference;
import spring_demo.ioc.PropertyValue;
import spring_demo.ioc.factory.BeanFactory;
import spring_demo.ioc.factory.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 23:58
 */
public class XmlBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	private List<String> beanDefinitionNames = new ArrayList<>();

	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

	private XmlBeanDefinitionReader xmlBeanDefinitionReader;

	public XmlBeanFactory(String location) throws Exception {
		xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
		loadBeanDefinitions(location);
	}

	@Override
	public Object getBean(String beanId) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
		if (beanDefinition == null) {
			throw new IllegalArgumentException("no this bean with name:" + beanId);
		}

		Object bean = beanDefinition.getBean();
		if (bean == null) {
			bean = createBean(beanDefinition);
			bean = initializeBean(bean, beanId);
			beanDefinition.setBean(bean);
		}
		return bean;
	}

	/**
	 * 根据BeanDefinition创建一个bean，返回的bean中属性的值已经被赋予
	 *
	 * @param bd bean对应的BeanDefinition
	 * @return 赋值后的Bean
	 * @throws Exception
	 */
	private Object createBean(BeanDefinition bd) throws Exception {
		Object bean = bd.getBeanClass().newInstance();
		applyPropertyValues(bean, bd);

		return bean;
	}

	/**
	 * 给bean里面的property赋值
	 *
	 * @param bean
	 * @param bd   bean对应的BeanDefinition
	 * @throws Exception
	 */
	private void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
		if (bean instanceof BeanFactoryAware) {
			((BeanFactoryAware) bean).setBeanFactory(this);
		}

		for (PropertyValue propertyValue : bd.getPropertyValues().getPropertyValues()) {
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				// beanReference中的bean根本没有用到？
				value = getBean(beanReference.getName());
			}

			try {
				Method declaredMethod = bean.getClass().getDeclaredMethod(
						"set" + propertyValue.getName().substring(0, 1).toUpperCase()
								+ propertyValue.getName().substring(1), value.getClass());
				declaredMethod.setAccessible(true);

				declaredMethod.invoke(bean, value);
			} catch (NoSuchMethodException e) {
				Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}

	private Object initializeBean(Object bean, String name) throws Exception{
		for (BeanPostProcessor beanPostProcessor:beanPostProcessors){
			bean = beanPostProcessor.postProcessBeforeInitialization(bean,name);
		}

		for (BeanPostProcessor beanPostProcessor:beanPostProcessors){
			bean = beanPostProcessor.postProcessAfterInitialization(bean,name);
		}

		return bean;
	}

	private void loadBeanDefinitions(String location) throws Exception {
		xmlBeanDefinitionReader.loadBeanDefinitions(location);
		regisiterBeanDefinition();
		regisiterBeanPostProcessor();
	}

	private void regisiterBeanDefinition() {
		for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			String name = entry.getKey();
			BeanDefinition beanDefinition = entry.getValue();
			beanDefinitionMap.put(name, beanDefinition);
			beanDefinitionNames.add(name);
		}
	}

	public void regisiterBeanPostProcessor() throws Exception {
		List beans = getBeansForType(BeanPostProcessor.class);
		for (Object bean : beans) {

			addBeanPostProcessor((BeanPostProcessor) bean);
		}
	}

	private void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		beanPostProcessors.add(beanPostProcessor);
	}

	/**
	 * 在beanDefinitionName中查找所有type类型的全部类
	 * @param type 在这里是BeanPostProcesser接口
	 * @return 返回每一个实现了BeanPostProcesser接口的类的List
	 * @throws Exception
	 */
	public List getBeansForType(Class type) throws Exception {
		List beans = new ArrayList();
		for (String beanDefinitionName : beanDefinitionNames) {
			// 判断每一个类是不是实现了BeanPostProcesser接口的类
			if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
				beans.add(getBean(beanDefinitionName));
			}
		}
		return beans;
	}
}






