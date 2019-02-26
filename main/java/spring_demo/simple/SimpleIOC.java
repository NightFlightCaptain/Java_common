package spring_demo.simple;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/1/28 19:02
 */
public class SimpleIOC {
	private Map<String, Object> beansMap = new HashMap<>();

	public SimpleIOC(String location) throws Exception {
		loadBeans(location);
	}

	public Object getBean(String name) {
		Object bean = beansMap.get(name);
		if (bean == null) {
			throw new IllegalArgumentException("there is no bean with name:" + name);
		}
		return bean;
	}

	private void loadBeans(String location) throws Exception {
//		加载xml
		InputStream inputStream = new FileInputStream(location);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(inputStream);
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();

		// 遍历bean标签
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				String id = ele.getAttribute("id");
				String className = ele.getAttribute("class");

				Class beanClass = null;
				try {
					beanClass = Class.forName(className);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return;
				}

				Object bean = beanClass.newInstance();

				NodeList propertyNodes = ele.getElementsByTagName("property");
				//遍历bean中的property属性
				for (int j = 0; j < propertyNodes.getLength(); j++) {
					Node propertyNode = propertyNodes.item(j);
					if (propertyNode instanceof Element) {
						Element propertyElement = (Element) propertyNode;
						String name = propertyElement.getAttribute("name");
						String value = propertyElement.getAttribute("value");

						// 利用反射将该属性设置为可访问
						Field decalredField = beanClass.getDeclaredField(name);
						decalredField.setAccessible(true);

						if (value != null && value.length() > 0) {
							decalredField.set(bean, value);
						} else {
							String ref = propertyElement.getAttribute("ref");
							if (ref == null || ref.length() == 0) {
								throw new IllegalArgumentException("ref config error");
							}
							// 将引用填充到相关字段中
							decalredField.set(bean, getBean(ref));
						}
						// 将bean注册到容器中去
					}
				}
				registerBean(id, bean);
			}
		}

	}

	private void registerBean(String id, Object bean) {
		beansMap.put(id, bean);
	}
}
