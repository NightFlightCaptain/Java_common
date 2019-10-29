package springdemo.factory;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 11:16
 */
public interface BeanFactory {
    Object getBean(String name) throws  Exception;
}
