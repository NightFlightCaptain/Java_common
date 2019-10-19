package spring_demo.simple.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import spring_demo.simple.ioc.io.ResourceLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author: 小栗旬
 * @Date: 2019/10/16 23:29
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputString();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        Element root = document.getDocumentElement();
        loadBeanDefinitions(root);
        inputStream.close();
    }

    private void loadBeanDefinitions(Element root) {
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                loadBeanDefinition(ele);
            }
        }
    }

    private void loadBeanDefinition(Element element) {
        String id = element.getAttribute("id");
        String className = element.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);

        loadPropertys(element, beanDefinition);
        getRegistry().put(id, beanDefinition);
    }

    private void loadPropertys(Element element, BeanDefinition beanDefinition) {
        NodeList nodeList = element.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;

                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                PropertyValue propertyValue;
                if (value != null && value.length() > 0) {
                    propertyValue = new PropertyValue(name, value);
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("ref config error with name:" + name);
                    }
                    BeanReference reference = new BeanReference(name, ref);
                    propertyValue = new PropertyValue(name, reference);
                }
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
        }
    }


}
