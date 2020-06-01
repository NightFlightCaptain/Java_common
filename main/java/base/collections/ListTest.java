package base.collections;

import java.io.Serializable;
import java.util.*;

/**
 * Author: 小栗旬
 * Date: 2018/12/25 21:50
 */
public class ListTest implements Serializable{

	static final Object OBJECT = new Object();
	private void ss(){

	}

	public static void main(String[] args) {

		List<String> stringList = new LinkedList<>();
		HashMap<Integer,Object> hashMap = new HashMap<>(10);
//		hashMap.put(1,OBJECT);
//		hashMap.put(17,OBJECT);
//
//		LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
//
//		TreeMap<String,String> treeMap = new TreeMap<>(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				if (o1.length() > o2.length()){
//					return 1;
//				}else {
//					return -1;
//				}
//			}
//		});
//		linkedHashMap.put("a","aa");
//		linkedHashMap.put("b","bb");

//      Hashtable中key和value都不能为null
//		Hashtable<String,String> hashtable = new Hashtable<>();
//		hashtable.put("a",null);

//		ConcurrentHashMap<String,String > concurrentHashMap = new ConcurrentHashMap<>();
//
//		HashSet<String> hashSet = new HashSet<>();
//
//		TreeMap<String,String> treeMap = new TreeMap<>();
//
//		ArrayList<String> arrayList = new ArrayList<>();
//		List<String> list = (List<String>) arrayList;
//
//		HashSet<SetTest> hashSet1 = new HashSet<>();
//		hashSet1.add(new SetTest("wan"));
//		hashSet1.add(new SetTest("www"));
//		Iterator<SetTest> iterator = hashSet1.iterator();
//		while (iterator.hasNext()){
//			System.out.println(iterator.next());
//		}

		List<String> list = new ArrayList<>();
		list.add("ddd");
		String[] strings = list.toArray(new String[list.size()]);
		list = Arrays.asList(strings);
		System.out.println(list);
	}
}
