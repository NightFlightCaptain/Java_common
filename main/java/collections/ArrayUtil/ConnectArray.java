package collections.ArrayUtil;

import code.compare.Interval;

import java.lang.reflect.InvocationTargetException;

/**
 * Author: 小栗旬
 * Date: 2019/2/21 14:25
 */
public class ConnectArray {
	public Object[] connat(Object[] a,Object[] b){
		int alen = a.length;
		int blen = b.length;
		Object[] newArray = new Object[alen+blen];
		System.arraycopy(a,0,newArray,0,alen);
		System.arraycopy(b,0,newArray,alen,blen);



		return newArray;

	}

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Interval[] intervals = new Interval[5];
		intervals[0] = new Interval(1,2);

		Class<?> clazz = intervals.getClass().getComponentType();
		Interval interval = (Interval)clazz.newInstance();

		System.out.println(interval);
	}


}
