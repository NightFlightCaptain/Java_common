package base.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/2/22 14:24
 *
 * Collections.unmodifiableMap(Map map)返回的是一个Collections中的内部类。
 * 这个类继承了Map，但是put，remove，putAll，clear等方法会直接报UnsupportedOperationException的错
 * 实际上这个类和放入的参数map是一个map，只是对上述的一些操作做了限制而已
 */
public class UnchangableMap {
	public static void main(String args[]) {
		Map<Integer,String> map = UnchangableMap.getAmap();
		map.put(1,"c");
		for (Map.Entry<Integer,String> entry :map.entrySet()){
			System.out.println(entry);
		}
	}

	private static Map<Integer, String> amap;

	public static Map<Integer, String> getAmap() {
		return amap;
	}

	static {
		HashMap<Integer,String> bmap = new HashMap<>();

		bmap.put(1,"a");
		bmap.put(2,"b");
		amap = Collections.unmodifiableMap(bmap);
		bmap.put(1,"A");
	}
}
