package spring_demo.simple.ioc.io;

import java.net.URL;

/**
 * @author: 小栗旬
 * @Date: 2019/10/17 15:00
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
