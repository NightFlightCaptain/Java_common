package springdemo.context;

import springdemo.BeanDefinition;
import springdemo.XmlBeanDefinitionReader;
import springdemo.factory.AbstractBeanFactory;
import springdemo.factory.AutowireCapableBeanFactory;
import springdemo.io.XmlResourceLoader;

import java.util.Map;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 11:45
 */
public class ClassPathXmlApplicaitonContext extends AbstractApplicationContext {
    private String location;

    public ClassPathXmlApplicaitonContext(String location) throws Exception{
        this(new AutowireCapableBeanFactory(),location);
    }

    public ClassPathXmlApplicaitonContext(AbstractBeanFactory beanFactory, String location) throws Exception{
        super(beanFactory);
        this.location = location;
        loadBeanDefinitions(this.beanFactory);
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new XmlResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(location);
        for (Map.Entry<String, BeanDefinition> entry:xmlBeanDefinitionReader.getRegister().entrySet()){
            beanFactory.registerBeanDefintions(entry.getKey(),entry.getValue());
        }
    }
}
