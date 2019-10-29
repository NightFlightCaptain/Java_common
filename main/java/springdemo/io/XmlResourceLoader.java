package springdemo.io;

import java.net.URL;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 10:38
 */
public class XmlResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
