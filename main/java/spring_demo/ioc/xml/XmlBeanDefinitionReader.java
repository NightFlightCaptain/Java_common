package spring_demo.ioc.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import spring_demo.ioc.BeanDefinition;
import spring_demo.ioc.BeanDefinitionReader;
import spring_demo.ioc.BeanReference;
import spring_demo.ioc.PropertyValue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/1/29 0:13
 *
 * 用来读取xml
 *
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

	/**
	 * BeanDefinition的存放map
	 */
	private Map<String, BeanDefinition> registry;

	public XmlBeanDefinitionReader() {
		registry = new HashMap<>();
	}

	@Override
	public void loadBeanDefinitions(String location) throws  Exception {
		InputStream inputStream = new FileInputStream(location);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputStream);
		Element root = doc.getDocumentElement();
		parseBeanDefinitions(root);
	}

	/**
	 * 遍历bean
	 * @param root 根节点
	 * @throws Exception
	 */
	private void parseBeanDefinitions(Element root) throws Exception {
		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				parseBeanDefinition(ele);
			}
		}
	}

	/**
	 * 对每一个bean进行操作
	 * @param ele
	 * @throws Exception
	 */
	private void parseBeanDefinition(Element ele) throws Exception {
		String beanID = ele.getAttribute("id");
		String className = ele.getAttribute("class");

		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName(className);
		// 为这个bean设置property的值
		processProperty(ele, beanDefinition);
		registry.put(beanID, beanDefinition);
	}

	private void processProperty(Element ele, BeanDefinition beanDefinition) {
		// 获取全部的property
		NodeList nodes = ele.getElementsByTagName("property");
		// 遍历property
		for (int i = 0; i < nodes.getLength(); i++) {
			Node propertyNode = nodes.item(i);
			if (propertyNode instanceof Element) {
				Element propertyElement = (Element) propertyNode;
				String name = propertyElement.getAttribute("name");
				String value = propertyElement.getAttribute("value");

				if (value != null && value.length() > 0) {
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
				} else {
					// 不是value，是ref
					String ref = propertyElement.getAttribute("ref");
					if (ref == null || ref.length() == 0) {
						throw new IllegalArgumentException("ref config error");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
			}
		}
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}
}















