package springdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/27 10:40
 */
public class PropertyValues {
    private List<PropertyValue> propertyValues;

    public PropertyValues() {
        propertyValues = new ArrayList<>();
    }

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
