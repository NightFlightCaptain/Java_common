package spring_demo.ioc2.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import spring_demo.ioc2.BeanDefinition;
import spring_demo.ioc2.BeanDefinitionReader;
import spring_demo.ioc2.BeanReference;
import spring_demo.ioc2.PropertyValue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 15:51
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

	private Map<String, BeanDefinition> beansMap;

	public XmlBeanDefinitionReader() {
		beansMap = new HashMap<>();
	}

	@Override
	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = new FileInputStream(location);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(inputStream);
		Element element = document.getDocumentElement();
		parseBeanDefinitions(element);
	}

	private void parseBeanDefinitions(Element root) {
		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				parseBeanDefinition(ele);
			}
		}
	}

	private void parseBeanDefinition(Element element) {
		String name = element.getAttribute("id");
		String className = element.getAttribute("class");

		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName(className);

		processProperty(element, beanDefinition);
		beansMap.put(name, beanDefinition);
	}

	private void processProperty(Element element, BeanDefinition beanDefinition) {
		NodeList nodes = element.getElementsByTagName("property");
		for (int i = 0; i < nodes.getLength(); i++) {
			Node propertyNode = nodes.item(i);
			if (propertyNode instanceof Element) {
				Element propertyElement = (Element) propertyNode;
				String name = propertyElement.getAttribute("name");
				String value = propertyElement.getAttribute("value");

				if (value != null && value.length() > 0) {
					beanDefinition.getPropertyValues().addProperty(new PropertyValue(name, value));
				} else {
					String ref = propertyElement.getAttribute("ref");
					if (ref == null || ref.length() == 0) {
						throw new IllegalArgumentException("ref config error with name " + name);
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addProperty(new PropertyValue(name, beanReference));
				}
			}
		}

	}

	public Map<String, BeanDefinition> getBeansMap() {
		return beansMap;
	}
}






