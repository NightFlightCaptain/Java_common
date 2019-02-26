package spring_demo.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 小栗旬
 * Date: 2019/1/29 0:04
 */
public class PropertyValues {
	private final List<PropertyValue> propertyValueList = new ArrayList<>();

	public void addPropertyValue(PropertyValue pv){
//		System.out.println(pv);
		// 这里可以对pv做一些处理
		this.propertyValueList.add(pv);
	}

	public List<PropertyValue> getPropertyValues() {
		return this.propertyValueList;
	}
}
