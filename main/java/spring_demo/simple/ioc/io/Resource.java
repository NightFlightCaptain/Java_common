package spring_demo.simple.ioc.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    InputStream getInputString() throws IOException;
}
