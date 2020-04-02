package code.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: 小栗旬
 * @Date: 2019/11/14 9:49
 */
public class MyClassLoader extends ClassLoader {
    private String path;

    // 重要的是重写findClass
    @Override
    protected Class<?> findClass(String name) {
        byte[] data = null;
        try {
            data = loadClassData(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String path) throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }

    /**
     * 一定要调用父类的loadClass，在父类的loadClass中实现了双亲委派
     * @param path class文件地址
     * @param name 类的名称
     * @return
     * @throws ClassNotFoundException
     */
    public Class<?> loadClass(String path, String name) throws ClassNotFoundException {
        this.path = path;
        return super.loadClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        System.out.println(myClassLoader.getParent());
        Class<?> myClass = myClassLoader.loadClass("C:\\Users\\wanhaoran\\Desktop\\People.class", "code.extend.example.People");
        System.out.println(myClass.getClassLoader());

        Class<?> sysClass = myClassLoader.loadClass("java.lang.Thread");
        System.out.println("sysClass:"+sysClass.getClassLoader());
        System.out.println(sysClass.getClassLoader());
        System.out.println(myClass.getPackage());

    }
}
