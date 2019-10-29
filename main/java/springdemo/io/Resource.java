package springdemo.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 10:36
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
