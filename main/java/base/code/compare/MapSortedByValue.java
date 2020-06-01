package base.code.compare;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author: 小栗旬
 * Date: 2019/2/20 21:57
 */
public class MapSortedByValue<K, V> {
	private Map<K, V> map = new HashMap<>();
	private Comparator<K> comparator = new Comparator<K>() {

		@Override
		public int compare(K o1, K o2) {
			Comparable comparable = (Comparable) map.get(o1);
			Comparable comparable2 = (Comparable) map.get(o2);
			return comparable.compareTo(comparable2);
		}
	};
	private Map<K, V> sortedMap = new TreeMap<K, V>(comparator);

	public MapSortedByValue() {
		sortedMap.putAll(map);
	}

	public void get(Integer integer){
		sortedMap.get(integer);
	}
	public void put(K key,V value){
		map.put(key,value);
		sortedMap.put(key,value);
	}

	@Override
	public String toString() {
		return sortedMap.toString();
	}

	public static void main(String[] args) {
		MapSortedByValue<Integer,Integer> map = new MapSortedByValue<>();
		map.put(1,2);
		map.put(7,19);
		map.put(9,4);
		map.put(3,9);
		map.put(8,5);
		System.out.println(map);

	}
}


