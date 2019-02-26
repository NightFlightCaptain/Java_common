package spring_demo.ioc2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 小栗旬
 * Date: 2019/1/30 15:47
 */
public class PropertyValues {
	private List<PropertyValue> propertyValues = new ArrayList<>();

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void addProperty(PropertyValue pv){
		//在这里可以对pv进行操作
		propertyValues.add(pv);
	}


	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}
}
