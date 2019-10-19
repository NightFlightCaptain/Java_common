package spring_demo.ioc2.xml;

import spring_demo.ioc2.BeanDefinition;
import spring_demo.ioc2.BeanPostProcessor;
import spring_demo.ioc2.BeanReference;
import spring_demo.ioc2.PropertyValue;
import spring_demo.ioc2.factory.BeanFactory;
import spring_demo.ioc2.factory.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 16:11
 */
public class XmlBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beansMap = new HashMap<>();
	private List<String> beanDefinitionNames = new ArrayList<>();
	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
	private XmlBeanDefinitionReader xmlBeanDefinitionReader;

	public XmlBeanFactory(String location) throws Exception {
		xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
		loadBeanDefinitions(location);
	}

	private void loadBeanDefinitions(String location) throws Exception {
		xmlBeanDefinitionReader.loadBeanDefinitions(location);
		registerBeanDefinition();
	}

	/**
	 * 将BeanDefinitionReader中map的BeanDefinition存放到BeanFactory中来
	 */
	private void registerBeanDefinition() {
		for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getBeansMap().entrySet()) {
			String name = entry.getKey();
			BeanDefinition bd = entry.getValue();
			beansMap.put(name, bd);
			beanDefinitionNames.add(name);
		}
	}

	private void registerBeanPostProcessor() throws Exception {
		List beans = getBeansForType(BeanPostProcessor.class);
		for (Object bean : beans) {

		}
	}

	private void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		beanPostProcessors.add(beanPostProcessor);
	}

	@Override
	public Object getBean(String beanID) throws Exception {
		BeanDefinition beanDefinition = beansMap.get(beanID);
		if (beanDefinition == null) {
			throw new IllegalArgumentException("no this bean with name: " + beanID);
		}

		Object bean = beanDefinition.getBean();
		if (bean == null) {
			bean = createBean(beanDefinition);
			bean = initializeBean(bean, beanID);
			beanDefinition.setBean(bean);
		}
		return bean;
	}

	private Object createBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = beanDefinition.getBeanClass().newInstance();
		//添加属性值
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	private Object initializeBean(Object bean, String name) throws Exception {
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
		}

		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
		}
		return bean;
	}

	/**
	 * 为bean添加属性值
	 *
	 * @param bean
	 * @param bd
	 * @throws Exception
	 */
	private void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
		if (bean instanceof BeanFactoryAware){
			((BeanFactoryAware)bean).setBeanFactory(this);
		}
		for (PropertyValue propertyValue : bd.getPropertyValues().getPropertyValues()) {
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				//后面反射要将value作为参数类型
				value = getBean(beanReference.getName());
			}

			try {
				Method declaredMethod = bean.getClass().getDeclaredMethod(
						"set" + propertyValue.getName().substring(0, 1).toUpperCase()
								+ propertyValue.getName().substring(1), value.getClass()
				);
				declaredMethod.setAccessible(true);
				declaredMethod.invoke(bean, value);
			} catch (NoSuchMethodException e) {
				Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}


	private List getBeansForType(Class type) throws Exception {
		List beans = new ArrayList();
		for (String beanDefinitionName : beanDefinitionNames) {
			if (type.isAssignableFrom(beansMap.get(beanDefinitionName).getBeanClass())) {
				beans.add(getBean(beanDefinitionName));
			}
		}
		return beans;
	}
}
