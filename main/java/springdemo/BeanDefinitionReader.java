package springdemo;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 10:49
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws IOException, ParserConfigurationException, SAXException;
}
