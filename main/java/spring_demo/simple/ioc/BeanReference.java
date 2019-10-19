package spring_demo.simple.ioc;

/**
 * @author: 小栗旬
 * @Date: 2019/10/16 23:26
 */
public class BeanReference {
    private String name;
    private Object ref;

    public BeanReference(String name, Object ref) {
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getRef() {
        return ref;
    }

    public void setRef(Object ref) {
        this.ref = ref;
    }
}
