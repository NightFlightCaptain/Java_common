package spring_demo.simple.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/16 23:25
 */
public class PropertyValues {
    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValues.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
